package io.github.yesminmarie.mslearningattendance.service.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceResult {
    private LocalDate classDate;
    private Boolean attendanceStatus;
}
