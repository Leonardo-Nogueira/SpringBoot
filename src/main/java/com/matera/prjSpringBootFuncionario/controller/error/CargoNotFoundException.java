package com.matera.prjSpringBootFuncionario.controller.error;

public class CargoNotFoundException extends Exception {

    public CargoNotFoundException() {
    }

    public CargoNotFoundException(String message) {
        super(message);
    }

    public CargoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CargoNotFoundException(Throwable cause) {
        super(cause);
    }

    public CargoNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
