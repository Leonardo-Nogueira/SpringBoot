package com.matera.prjSpringBootFuncionario.controller;

import com.matera.prjSpringBootFuncionario.controller.controller.ControllerFunc;
import com.matera.prjSpringBootFuncionario.controller.error.DepartamentoNotFoundException;
import com.matera.prjSpringBootFuncionario.controller.error.IdNotFoundException;
import com.matera.prjSpringBootFuncionario.controller.model.Cargo;
import com.matera.prjSpringBootFuncionario.controller.model.Departamento;
import com.matera.prjSpringBootFuncionario.controller.model.Funcionario;
import com.matera.prjSpringBootFuncionario.controller.model.FuncionarioDAO;
import com.matera.prjSpringBootFuncionario.controller.repository.FuncRepository;
import com.matera.prjSpringBootFuncionario.controller.service.ServiceBusiness;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControllerFuncTest {


    @Mock
    private ServiceBusiness serviceBusiness;

    @InjectMocks
    private ControllerFunc controller;


    @Test
    public void testProblemaNotFound() throws IdNotFoundException {

        doThrow(new IdNotFoundException()).when(serviceBusiness).deletarOFuncionarioPeloIdInseridoPeloUsuario(anyInt());

        ResponseEntity<FuncionarioDAO> responseEntity = controller.deletarFuncionario(3);

        assertEquals(ResponseEntity.notFound().build(), responseEntity);
    }



    @Test
    public void testProblemaNotUpgrade() throws IdNotFoundException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        doThrow(new IdNotFoundException()).when(serviceBusiness).alterarFuncionarioPeloIdInserido(anyObject(),anyInt());

        ResponseEntity<Funcionario> responseEntity = controller.alterarFuncionario(funcionarioDAO,3);

        assertEquals(ResponseEntity.notFound().build(), responseEntity);
    }

}
