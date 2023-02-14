package io.github.yesminmarie.mslearningcourse.exceptions;

public class CourseLengthException extends RuntimeException{
    public CourseLengthException(){
        super("Course name less than three characters!");
    }
}
