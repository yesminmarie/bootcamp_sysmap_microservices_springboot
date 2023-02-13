package io.github.yesminmarie.mslearningcourse.controller;

import io.github.yesminmarie.mslearningcourse.controller.input.CourseInput;
import io.github.yesminmarie.mslearningcourse.service.CourseService;
import io.github.yesminmarie.mslearningcourse.service.result.CourseResult;
import io.github.yesminmarie.mslearningcourse.service.result.CourseResultId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    @Operation(description = "Create a new course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created course")
    })
    public ResponseEntity<CourseResultId> createCourse(@RequestBody CourseInput courseInput){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.createCourse(courseInput));
    }

    @GetMapping(params = "courseId")
    @Operation(description = "Get course by Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Course found"),
            @ApiResponse(responseCode = "404", description = "Course not found")
    })
    public ResponseEntity<CourseResult> getCourseId(@RequestParam("courseId") UUID courseId){
        return ResponseEntity.ok(courseService.getCourseId(courseId));
    }

    @GetMapping("/")
    @Operation(description = "List all courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Courses found")
    })
    public ResponseEntity<List<CourseResult>> getCourseId(){
        return ResponseEntity.ok(courseService.getAll());
    }
}
