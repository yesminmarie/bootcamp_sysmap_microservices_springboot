package io.github.yesminmarie.mslearningcad.controller;

import io.github.yesminmarie.mslearningcad.controller.input.CreateStudentInput;
import io.github.yesminmarie.mslearningcad.exception.CourseNotFoundException;
import io.github.yesminmarie.mslearningcad.exception.MicroservicesComunicationException;
import io.github.yesminmarie.mslearningcad.service.StudentService;
import io.github.yesminmarie.mslearningcad.service.result.CreateStudentResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<CreateStudentResult> createStudent(@RequestBody CreateStudentInput createStudentInput)
            throws CourseNotFoundException, MicroservicesComunicationException {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(createStudentInput));
    }
}
