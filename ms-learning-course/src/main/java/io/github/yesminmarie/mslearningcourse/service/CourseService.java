package io.github.yesminmarie.mslearningcourse.service;

import io.github.yesminmarie.mslearningcourse.controller.input.CourseInput;
import io.github.yesminmarie.mslearningcourse.service.result.CourseResult;
import io.github.yesminmarie.mslearningcourse.service.result.CourseResultId;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    CourseResultId createCourse(CourseInput courseInput);
    CourseResult getCourseId(UUID courseId);
    List<CourseResult> getAll();
}
