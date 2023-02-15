package io.github.yesminmarie.mslearningattendance.domain.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientCourseResult {

    private UUID courseId;
    private String courseName;
    private Boolean status;
    private LocalDate createdOn;
}
