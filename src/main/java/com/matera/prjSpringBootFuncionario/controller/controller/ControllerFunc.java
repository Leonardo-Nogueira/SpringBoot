package com.matera.prjSpringBootFuncionario.controller.controller;


import com.matera.prjSpringBootFuncionario.controller.error.CargoNotFoundException;
import com.matera.prjSpringBootFuncionario.controller.error.DepartamentoNotFoundException;
import com.matera.prjSpringBootFuncionario.controller.error.IdNotFoundException;
import com.matera.prjSpringBootFuncionario.controller.model.Funcionario;
import com.matera.prjSpringBootFuncionario.controller.model.FuncionarioDAO;
import com.matera.prjSpringBootFuncionario.controller.service.ServiceBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("func")
public class ControllerFunc {

    @Autowired
    private ServiceBusiness serviceBusiness;



    @PostMapping
    public ResponseEntity<FuncionarioDAO> inserirFuncionario(@RequestBody FuncionarioDAO funcionario) {
        try {
            serviceBusiness.adicionarFuncionario(funcionario);
            return ResponseEntity.ok().build();
        } catch (DepartamentoNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (CargoNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public Iterable<FuncionarioDAO> listar() {
        return serviceBusiness.buscarOsFuncionarios();


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FuncionarioDAO> deletarFuncionario(@PathVariable Integer id) throws IdNotFoundException {

        try {
            serviceBusiness.deletarOFuncionarioPeloIdInseridoPeloUsuario(id);
            return ResponseEntity.ok().build();
        } catch (IdNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> alterarFuncionario(@RequestBody FuncionarioDAO funcionarioDAO, @PathVariable Integer id) throws IdNotFoundException {

        try {
            serviceBusiness.alterarFuncionarioPeloIdInserido(funcionarioDAO,id);
            return ResponseEntity.ok().build();
        } catch (IdNotFoundException e) {
            return ResponseEntity.notFound().build();
        }


    }






}

