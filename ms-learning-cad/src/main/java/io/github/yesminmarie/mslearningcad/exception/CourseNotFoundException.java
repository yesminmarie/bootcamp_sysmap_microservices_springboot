package io.github.yesminmarie.mslearningcad.exception;

public class CourseNotFoundException extends Exception{
    public CourseNotFoundException(){
        super("Course not found for informed course id");
    }
}
