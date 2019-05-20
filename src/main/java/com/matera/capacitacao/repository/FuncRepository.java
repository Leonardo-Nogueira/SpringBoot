package com.matera.capacitacao.repository;
import com.matera.capacitacao.model.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncRepository extends CrudRepository<Funcionario,Integer> {
    List<Funcionario> findByNome(String nome);


}
