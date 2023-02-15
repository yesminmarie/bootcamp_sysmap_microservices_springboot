package io.github.yesminmarie.mslearningattendance.controller.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterStudentAttendanceInput {
    private Boolean attendanceStatus;
}
