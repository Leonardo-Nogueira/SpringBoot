package com.matera.prjSpringBootFuncionario.controller.repository;

import com.matera.prjSpringBootFuncionario.controller.model.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CargoRepository extends CrudRepository<Cargo,Integer> {
    Optional<Cargo> findByCargo(String cargo);


}