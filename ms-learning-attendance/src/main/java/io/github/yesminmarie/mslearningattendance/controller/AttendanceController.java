package io.github.yesminmarie.mslearningattendance.controller;

import io.github.yesminmarie.mslearningattendance.controller.input.RegisterStudentAttendanceInput;
import io.github.yesminmarie.mslearningattendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/courses/{courseId}/students/{studentId}/attendances")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerStudentAttendance(
            @RequestBody RegisterStudentAttendanceInput registerStudentAttendanceInput,
            @PathVariable UUID courseId,
            @PathVariable UUID studentId){
        attendanceService.registerStudentAttendance(registerStudentAttendanceInput, courseId, studentId);
    }
}
