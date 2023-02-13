package io.github.yesminmarie.mslearningcourse.controller;

import io.github.yesminmarie.mslearningcourse.exceptions.CourseAlreadyExistsException;
import io.github.yesminmarie.mslearningcourse.exceptions.CourseLengthException;
import io.github.yesminmarie.mslearningcourse.exceptions.CourseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler(CourseAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleCourseAlreadyExistsException(CourseAlreadyExistsException ex){
        return createBodyMessage(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CourseLengthException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleCourseLengthException(CourseLengthException ex){
        return createBodyMessage(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleCourseNotFoundException(CourseNotFoundException ex){
        return createBodyMessage(ex, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Object> createBodyMessage(RuntimeException ex, HttpStatus httpStatus){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("errorCode", httpStatus);
        body.put("errorMessage", ex.getMessage());
        return new ResponseEntity<>(body, httpStatus);
    }
}
