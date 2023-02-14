package io.github.yesminmarie.mslearningcad.service.event;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class CreateStudentEvent implements Serializable {
    private UUID studentId;
    private String fullName;
    private UUID courseId;
}
