package io.github.yesminmarie.mslearningcourse.controller.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInput {
    private String courseName;
    private Boolean status;
}
