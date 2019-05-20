package com.matera.prjSpringBootFuncionario.controller.error;

public class DepartamentoNotFoundException extends Exception{
    public DepartamentoNotFoundException() {
    }

    public DepartamentoNotFoundException(String message) {
        super(message);
    }

    public DepartamentoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartamentoNotFoundException(Throwable cause) {
        super(cause);
    }

    public DepartamentoNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
