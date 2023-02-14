package io.github.yesminmarie.mslearningcad.controller;

import io.github.yesminmarie.mslearningcad.controller.input.CreateStudentInput;
import io.github.yesminmarie.mslearningcad.exception.CourseNotFoundException;
import io.github.yesminmarie.mslearningcad.exception.MicroservicesComunicationException;
import io.github.yesminmarie.mslearningcad.service.StudentService;
import io.github.yesminmarie.mslearningcad.service.result.CreateStudentResult;
import io.github.yesminmarie.mslearningcad.service.result.GetStudentResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("{studentId}")
    public ResponseEntity<GetStudentResult> getStudentById(@PathVariable UUID studentId){
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }
}
