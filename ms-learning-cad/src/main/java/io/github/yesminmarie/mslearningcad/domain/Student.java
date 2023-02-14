package io.github.yesminmarie.mslearningcad.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Document
public class Student {

    @Id
    private String id;

    @Indexed(unique = true)
    private UUID studentId;
    private String firstName;
    private String lastName;
    private String document;
    private LocalDate birthDate;
    private UUID courseId;
    private Boolean status;
    private LocalDate createdOn;
}
