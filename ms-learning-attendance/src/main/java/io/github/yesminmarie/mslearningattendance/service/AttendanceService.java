package io.github.yesminmarie.mslearningattendance.service;

import io.github.yesminmarie.mslearningattendance.controller.input.RegisterStudentAttendanceInput;

import java.util.UUID;

public interface AttendanceService {
    void registerStudentAttendance(
            RegisterStudentAttendanceInput registerStudentAttendanceInput,
            UUID courseId,
            UUID studentId);
}
