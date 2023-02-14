package io.github.yesminmarie.mslearningcad.service;

import io.github.yesminmarie.mslearningcad.controller.input.CreateStudentInput;
import io.github.yesminmarie.mslearningcad.exception.CourseNotFoundException;
import io.github.yesminmarie.mslearningcad.exception.MicroservicesComunicationException;
import io.github.yesminmarie.mslearningcad.service.result.CreateStudentResult;
import io.github.yesminmarie.mslearningcad.service.result.GetStudentResult;

import java.util.UUID;

public interface StudentService {
    CreateStudentResult createStudent(CreateStudentInput studentInput) throws CourseNotFoundException, MicroservicesComunicationException;
    GetStudentResult getStudentById(UUID studentId);
}
