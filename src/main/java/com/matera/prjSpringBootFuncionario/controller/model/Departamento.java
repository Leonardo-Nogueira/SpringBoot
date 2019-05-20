package com.matera.prjSpringBootFuncionario.controller.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento {
    @Id
    private int id;
    private String departamento;

    public Departamento(){

    }

    public Departamento(int id, String departamento) {
        this.id = id;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}

