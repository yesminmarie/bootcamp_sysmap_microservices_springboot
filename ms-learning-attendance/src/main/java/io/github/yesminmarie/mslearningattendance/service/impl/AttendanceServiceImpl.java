package io.github.yesminmarie.mslearningattendance.service.impl;

import io.github.yesminmarie.mslearningattendance.controller.input.RegisterStudentAttendanceInput;
import io.github.yesminmarie.mslearningattendance.data.AttendanceRepository;
import io.github.yesminmarie.mslearningattendance.data.StudentRepository;
import io.github.yesminmarie.mslearningattendance.domain.Attendance;
import io.github.yesminmarie.mslearningattendance.domain.Student;
import io.github.yesminmarie.mslearningattendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

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

}
