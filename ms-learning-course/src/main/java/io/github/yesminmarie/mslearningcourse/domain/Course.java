package io.github.yesminmarie.mslearningcourse.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Document
public class Course {

    @Id
    private String id;

    @Indexed(unique = true)
    private UUID courseId;
    private String courseName;
    private Boolean status;

    private LocalDate createdOn;
}
