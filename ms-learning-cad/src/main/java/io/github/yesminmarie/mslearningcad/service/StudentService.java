package io.github.yesminmarie.mslearningcad.service;

import io.github.yesminmarie.mslearningcad.controller.input.CreateStudentInput;
import io.github.yesminmarie.mslearningcad.exception.CourseNotFoundException;
import io.github.yesminmarie.mslearningcad.exception.MicroservicesComunicationException;
import io.github.yesminmarie.mslearningcad.service.result.CreateStudentResult;

public interface StudentService {
    CreateStudentResult createStudent(CreateStudentInput studentInput) throws CourseNotFoundException, MicroservicesComunicationException;
}
