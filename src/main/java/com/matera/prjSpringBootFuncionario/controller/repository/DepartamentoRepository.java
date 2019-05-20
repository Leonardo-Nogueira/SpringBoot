package com.matera.prjSpringBootFuncionario.controller.repository;

import com.matera.prjSpringBootFuncionario.controller.model.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento,Integer> {
    Optional<Departamento> findByDepartamento(String departamento);


}
