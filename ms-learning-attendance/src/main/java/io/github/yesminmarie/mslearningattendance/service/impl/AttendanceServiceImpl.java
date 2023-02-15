package io.github.yesminmarie.mslearningattendance.service.impl;

import io.github.yesminmarie.mslearningattendance.controller.input.RegisterStudentAttendanceInput;
import io.github.yesminmarie.mslearningattendance.data.AttendanceRepository;
import io.github.yesminmarie.mslearningattendance.data.StudentRepository;
import io.github.yesminmarie.mslearningattendance.domain.Attendance;
import io.github.yesminmarie.mslearningattendance.domain.Student;
import io.github.yesminmarie.mslearningattendance.domain.client.GetStudentResult;
import io.github.yesminmarie.mslearningattendance.service.AttendanceService;
import io.github.yesminmarie.mslearningattendance.service.result.AttendanceResult;
import io.github.yesminmarie.mslearningattendance.service.result.AttendancesByStudentResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final WebClient webClient;
    private final StudentRepository studentRepository;
    private final AttendanceRepository attendanceRepository;
    @Override
    public void registerStudentAttendance(
            RegisterStudentAttendanceInput registerStudentAttendanceInput,
            UUID courseId,
            UUID studentId) {

        Student student = studentRepository.findByStudentIdAndCourseId(studentId, courseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Student not found for course id!"));

        Attendance attendance = new Attendance();
        attendance.setStudentId(student.getStudentId());
        attendance.setCourseId(student.getCourseId());
        attendance.setClassDate(LocalDate.now());
        attendance.setAttendanceStatus(registerStudentAttendanceInput.getAttendanceStatus());
        attendanceRepository.save(attendance);
    }

    @Override
    public AttendancesByStudentResult getAttendancesByStudentResult(UUID studentId) {
        GetStudentResult student = searchStudentWebClient(studentId);

        AttendancesByStudentResult attendancesByStudentResult = new AttendancesByStudentResult();

        attendancesByStudentResult.setFullName(student.getFullName());
        attendancesByStudentResult.setCourseName(student.getCourseName());

        List<AttendanceResult> attendances = attendanceRepository.findAllByStudentId(studentId)
                .stream().map(attendance -> {
                    AttendanceResult attendanceResult = new AttendanceResult();
                    attendanceResult.setClassDate(attendance.getClassDate());
                    attendanceResult.setAttendanceStatus(attendance.getAttendanceStatus());
                    return attendanceResult;
                }).toList();
        attendancesByStudentResult.setAttendances(attendances);

        return attendancesByStudentResult;
    }

    private GetStudentResult searchStudentWebClient(UUID studentId){
        Optional<GetStudentResult> studentResult = Optional.ofNullable(webClient.get()
                .uri("http://localhost:8082/api/v1/students/" + studentId)
                .retrieve()
                .bodyToMono(GetStudentResult.class)
                .block());

        if(studentResult.isEmpty()){
            throw new IllegalArgumentException("Student not found!");
        }
        return studentResult.get();
    }

}
