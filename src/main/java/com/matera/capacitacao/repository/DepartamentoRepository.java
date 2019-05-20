package com.matera.capacitacao.repository;

import com.matera.capacitacao.model.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento,Integer> {
    Optional<Departamento> findByDepartamento(String departamento);


}
