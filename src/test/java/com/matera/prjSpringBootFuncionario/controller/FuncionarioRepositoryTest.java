package com.matera.prjSpringBootFuncionario.controller;


import com.matera.prjSpringBootFuncionario.controller.model.Cargo;
import com.matera.prjSpringBootFuncionario.controller.model.Departamento;
import com.matera.prjSpringBootFuncionario.controller.model.Funcionario;
import com.matera.prjSpringBootFuncionario.controller.repository.FuncRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class FuncionarioRepositoryTest {
    @Autowired
    private FuncRepository funcRepository;
    @Rule
    public ExpectedException thworw = ExpectedException.none();
    @Test
    public void criarUsuarioNoBancoDeDados(){


        Cargo cargo = new Cargo(1,"PROGRAMADOR"); //serviceBusiness.buscaEntidadeCargoAtravesDoNomeDoCargo(funcionarios);

        Departamento departamento =  new Departamento(2,"SUPORTE");// serviceBusiness.buscaEntidadeDepartamentoAtravesDoNomeDoDepartamento(funcionarios);

        Funcionario funcionario = new Funcionario(5,"Nome","sobreNome",8.0,5,cargo,departamento,"Leo@com.br");
        System.out.println(funcionario);
        funcRepository.save(funcionario);
    }


    @Test
    public void deletarUsuarioNoBancoDeDados(){

        Cargo cargo = new Cargo(1,"PROGRAMADOR"); //serviceBusiness.buscaEntidadeCargoAtravesDoNomeDoCargo(funcionarios);

        Departamento departamento =  new Departamento(2,"SUPORTE");// serviceBusiness.buscaEntidadeDepartamentoAtravesDoNomeDoDepartamento(funcionarios);

        Funcionario funcionario = new Funcionario(5,"Nome","sobreNome",8.0,5,cargo,departamento,"Leo@com.br");
        funcRepository.deleteById(funcionario.getId());
    }


}
