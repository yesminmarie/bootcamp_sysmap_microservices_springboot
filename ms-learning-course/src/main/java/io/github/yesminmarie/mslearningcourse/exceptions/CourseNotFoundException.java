package io.github.yesminmarie.mslearningcourse.exceptions;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(){
        super("Course not found!");
    }
}
