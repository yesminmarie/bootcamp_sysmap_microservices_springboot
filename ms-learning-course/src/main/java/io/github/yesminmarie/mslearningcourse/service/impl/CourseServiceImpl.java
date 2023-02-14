package io.github.yesminmarie.mslearningcourse.service.impl;

import io.github.yesminmarie.mslearningcourse.controller.input.CourseInput;
import io.github.yesminmarie.mslearningcourse.data.CourseRepository;
import io.github.yesminmarie.mslearningcourse.domain.Course;
import io.github.yesminmarie.mslearningcourse.exceptions.CourseAlreadyExistsException;
import io.github.yesminmarie.mslearningcourse.exceptions.CourseLengthException;
import io.github.yesminmarie.mslearningcourse.exceptions.CourseNotFoundException;
import io.github.yesminmarie.mslearningcourse.service.CourseService;
import io.github.yesminmarie.mslearningcourse.service.result.CourseResult;
import io.github.yesminmarie.mslearningcourse.service.result.CourseResultId;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final ModelMapper modelMapper;

    @Override
    public CourseResultId createCourse(CourseInput courseInput) {

        if(courseInput.getCourseName().length() <= 3){
            throw new CourseLengthException();
        }
        Optional<Course> existsCourse = courseRepository.findByCourseName(courseInput.getCourseName());
        if(existsCourse.isEmpty()){
            Course course = modelMapper.map(courseInput, Course.class);
            course.setCourseId(UUID.randomUUID());
            course.setStatus(true);
            course.setCreatedOn(LocalDate.now());
            courseRepository.save(course);
            return modelMapper.map(course, CourseResultId.class);
        }
        throw new CourseAlreadyExistsException();
    }

    @Override
    public CourseResult getCourseId(UUID courseId) {
        Optional<Course> course = Optional.ofNullable(courseRepository.findByCourseId(courseId)
                .orElseThrow(() ->
                        new CourseNotFoundException()));
        return modelMapper.map(course, CourseResult.class);
    }

    @Override
    public List<CourseResult> getAll() {
        return courseRepository.findAll()
                .stream()
                .map(course -> modelMapper.map(course, CourseResult.class))
                .collect(Collectors.toList());
    }
}
