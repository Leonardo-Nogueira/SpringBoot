package com.matera.capacitacao.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name="funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min=1, max=30)
    private String nome;

    @NotNull
    @Size(min=1, max=30)
    private String sobreNome;

    @NotNull
    private double salario;

    @NotNull
    private int nDependentes;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "departemento_id")
    private Departamento departamento;

    @Email(message = "Insira email corretamente")
    private String email;


    public Funcionario(Integer id, String nome, String sobreNome, double salario, int nDependentes, Cargo cargo, Departamento departamento, String email) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.salario = salario;
        this.nDependentes = nDependentes;
        this.cargo = cargo;
        this.departamento = departamento;
        this.email = email;
    }

    public Funcionario() {

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getnDependentes() {
        return nDependentes;
    }

    public void setnDependentes(int nDependentes) {
        this.nDependentes = nDependentes;
    }


    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
