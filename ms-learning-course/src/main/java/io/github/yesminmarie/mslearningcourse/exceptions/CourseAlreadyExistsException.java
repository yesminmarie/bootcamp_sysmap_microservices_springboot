package io.github.yesminmarie.mslearningcourse.exceptions;

public class CourseAlreadyExistsException extends RuntimeException{
    public CourseAlreadyExistsException(){
        super("Course already exists!");
    }
}
