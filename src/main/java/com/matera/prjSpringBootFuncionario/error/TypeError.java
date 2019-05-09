package com.matera.prjSpringBootFuncionario.error;

public class TypeError {
    private String error;

    public TypeError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
