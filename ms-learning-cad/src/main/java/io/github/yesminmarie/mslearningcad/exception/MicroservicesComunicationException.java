package io.github.yesminmarie.mslearningcad.exception;

import lombok.Getter;

public class MicroservicesComunicationException extends Exception{

    @Getter
    private final Integer status;

    public MicroservicesComunicationException(String msg, Integer status){
        super(msg);
        this.status = status;
    }
}
