package com.matera.prjSpringBootFuncionario.controller.error;

public class TypeError extends Exception{
    public TypeError() {
    }

    public TypeError(String message) {
        super(message);
    }

    public TypeError(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeError(Throwable cause) {
        super(cause);
    }

    public TypeError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
