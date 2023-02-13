package io.github.yesminmarie.mslearningcourse.controller;

import io.github.yesminmarie.mslearningcourse.controller.input.CourseInput;
import io.github.yesminmarie.mslearningcourse.service.CourseService;
import io.github.yesminmarie.mslearningcourse.service.result.CourseResult;
import io.github.yesminmarie.mslearningcourse.service.result.CourseResultId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/courses")
@Api("Courses API")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    @ApiOperation("Create a new course")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created course")
    })
    public ResponseEntity<CourseResultId> createCourse(@RequestBody CourseInput courseInput){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.createCourse(courseInput));
    }

    @GetMapping(params = "courseId")
    @ApiOperation("Get course by Id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Course found"),
            @ApiResponse(code = 404, message = "Course not found")
    })
    public ResponseEntity<CourseResult> getCourseId(@RequestParam("courseId") UUID courseId){
        return ResponseEntity.ok(courseService.getCourseId(courseId));
    }

    @GetMapping
    @ApiOperation("Get all courses")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Courses found")
    })
    public ResponseEntity<List<CourseResult>> getCourseId(){
        return ResponseEntity.ok(courseService.getAll());
    }
}
