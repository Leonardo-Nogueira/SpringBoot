package com.matera.prjSpringBootFuncionario.service;

import java.util.ArrayList;
import java.util.*;

public class Funcionario {
    private String nome;
    private String sobreNome;
    private double salario;
    private int nDependentes;
    private Cargo cargo;
    private Departemento departemento;
    public static List<Funcionario> listFunc;
    private int codigoUnico;

//    static {
//        carasteristicaFuncionario();
//    }


    public Funcionario(String nome, String sobreNome, double salario, int nDependentes, Cargo cargo, Departemento departemento, int codigoUnico) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.salario = salario;
        this.nDependentes = nDependentes;
        this.cargo = cargo;
        this.departemento = departemento;
        this.codigoUnico = codigoUnico;
    }

    public Funcionario() {

    }


//    private static void carasteristicaFuncionario() {
//
//        listFunc = new ArrayList<>(Arrays.asList(new Funcionario("Leonardo","Nogueira",8.0,5,"Programador","Core",5)));
//    }




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

    public Departemento getDepartemento() {
        return departemento;
    }

    public void setDepartemento(Departemento departemento) {
        this.departemento = departemento;
    }

    public int getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return codigoUnico == that.codigoUnico;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoUnico);
    }
}
