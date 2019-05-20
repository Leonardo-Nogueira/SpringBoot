package com.matera.prjSpringBootFuncionario.controller;

import com.matera.prjSpringBootFuncionario.controller.controller.ControllerFunc;
import com.matera.prjSpringBootFuncionario.controller.error.IdNotFoundException;
import com.matera.prjSpringBootFuncionario.controller.model.Funcionario;
import com.matera.prjSpringBootFuncionario.controller.model.FuncionarioTO;
import com.matera.prjSpringBootFuncionario.controller.service.ServiceBusiness;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class ControllerFuncTest {


    @Mock
    private ServiceBusiness serviceBusiness;

    @InjectMocks
    private ControllerFunc controller;


    @Test
    public void testProblemaNotFound() throws IdNotFoundException {

        doThrow(new IdNotFoundException()).when(serviceBusiness).deletarOFuncionarioPeloIdInseridoPeloUsuario(anyInt());

        ResponseEntity<FuncionarioTO> responseEntity = controller.deletarFuncionario(3);

        assertEquals(ResponseEntity.notFound().build(), responseEntity);
    }



    @Test
    public void testProblemaNotUpgrade() throws IdNotFoundException {
        FuncionarioTO funcionarioTO = new FuncionarioTO();
        doThrow(new IdNotFoundException()).when(serviceBusiness).alterarFuncionarioPeloIdInserido(anyObject(),anyInt());

        ResponseEntity<Funcionario> responseEntity = controller.alterarFuncionario(funcionarioTO,3);

        assertEquals(ResponseEntity.notFound().build(), responseEntity);
    }

}
