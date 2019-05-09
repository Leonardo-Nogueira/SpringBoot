package com.matera.prjSpringBootFuncionario.controller;


import com.matera.prjSpringBootFuncionario.error.TypeError;
import com.matera.prjSpringBootFuncionario.service.Funcionario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("func")
public class ControllerFunc {
    Funcionario func = new Funcionario();
    private List<Funcionario> listf = new ArrayList<>();

    @GetMapping // Por aonde ele identifica o Get
    public ResponseEntity<?> listarTodosFuncionarios() {
        return new ResponseEntity<>(listf, HttpStatus.OK);
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<?> getByName(@PathVariable("codigo") int codigo) {
        Funcionario funcionario = new Funcionario();
        funcionario.setCodigoUnico(codigo);
        int aux = listf.indexOf(funcionario);
        if (aux == -1)
            return new ResponseEntity<>(new TypeError("Não foi possivel achar"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listf.get(aux), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insecFunc(@RequestBody Funcionario funcionario){
        Funcionario func = new Funcionario();
        listf.add(funcionario);
        return new ResponseEntity<>(funcionario,HttpStatus.OK);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteFunc(@RequestBody Funcionario funcionario){
        listf.remove(funcionario);
        return new ResponseEntity<>(funcionario,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> upgradeFunc(@RequestBody Funcionario funcionario){
        listf.remove(funcionario);
        listf.add(funcionario);
        return new ResponseEntity<>(funcionario,HttpStatus.OK);
    }




}

