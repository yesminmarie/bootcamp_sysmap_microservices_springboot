package io.github.yesminmarie.mslearningattendance.service.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendancesByStudentResult {
    private String fullName;
    private String courseName;
    private List<AttendanceResult> attendances;
}
