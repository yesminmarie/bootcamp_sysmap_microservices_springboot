package io.github.yesminmarie.mslearningcad.controller.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentInput {
    private String firstName;
    private String lastName;
    private String document;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    private UUID courseId;
}
