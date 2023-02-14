package io.github.yesminmarie.mslearningcad.clients.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResult {

    private UUID courseId;
    private String courseName;
    private Boolean status;
    private LocalDate createdOn;
}
