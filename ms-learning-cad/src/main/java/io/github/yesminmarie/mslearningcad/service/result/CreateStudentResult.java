package io.github.yesminmarie.mslearningcad.service.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentResult {
    private UUID studentId;
}
