package io.github.yesminmarie.mslearningattendance.domain.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStudentResult {
    private String fullName;
    private String document;
    private LocalDate birthDate;
    private String courseName;
    private Boolean status;
}
