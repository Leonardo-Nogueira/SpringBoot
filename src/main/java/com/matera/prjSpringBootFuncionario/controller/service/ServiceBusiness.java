package com.matera.prjSpringBootFuncionario.controller.service;

import com.matera.prjSpringBootFuncionario.controller.error.CargoNotFoundException;
import com.matera.prjSpringBootFuncionario.controller.error.DepartamentoNotFoundException;
import com.matera.prjSpringBootFuncionario.controller.error.IdNotFoundException;
import com.matera.prjSpringBootFuncionario.controller.repository.CargoRepository;
import com.matera.prjSpringBootFuncionario.controller.repository.DepartamentoRepository;
import com.matera.prjSpringBootFuncionario.controller.model.Cargo;
import com.matera.prjSpringBootFuncionario.controller.model.Departamento;
import com.matera.prjSpringBootFuncionario.controller.model.Funcionario;
import com.matera.prjSpringBootFuncionario.controller.model.FuncionarioDAO;
import com.matera.prjSpringBootFuncionario.controller.repository.FuncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceBusiness {


    @Autowired
    private FuncRepository funcDao;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;


/* O metodo adicionarFuncionario recebe um JSon do banco, aṕos receber o json o metodo chama outros dois metodos
que converte por assim dizer uma String em objeto e envia para o banco.

 */

    public void adicionarFuncionario(FuncionarioDAO funcionario)  throws DepartamentoNotFoundException, CargoNotFoundException {
        System.out.println("ola");
        Funcionario func = new Funcionario();
        Cargo cargo = buscaEntidadeCargoAtravesDoNomeDoCargo(funcionario);
        Departamento departamento = buscaEntidadeDepartamentoAtravesDoNomeDoDepartamento(funcionario);
        func.setNome(funcionario.getNome());
        func.setSobreNome(funcionario.getSobreNome());
        func.setEmail(funcionario.getEmail());
        func.setSalario(funcionario.getSalario());
        func.setnDependentes(funcionario.getnDependentes());
        func.setCargo(cargo);

        func.setDepartamento(departamento);
        funcDao.save(func);
    }

    public List<FuncionarioDAO> buscarOsFuncionarios(){
        Iterable<Funcionario> listaFunc = funcDao.findAll();
        List<FuncionarioDAO> listaFuncTAO = new ArrayList<>();
        for(Funcionario funcionario : listaFunc){
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            Optional<Cargo> cargo = cargoRepository.findById(funcionario.getCargo().getId());
            Optional<Departamento> departamento = departamentoRepository.findById(funcionario.getDepartamento().getId());
            funcionarioDAO = buscarCamposOsCamposDosFuncionariosESetarElesNoMetodo(funcionario,cargo,departamento);
            listaFuncTAO.add(funcionarioDAO);
        }
        System.out.println("--------------------");
        System.out.println(listaFuncTAO);
        return  listaFuncTAO;
    }

    public void deletarOFuncionarioPeloIdInseridoPeloUsuario(Integer id) throws IdNotFoundException {
        Optional<Funcionario> listaFunc = funcDao.findById(id);
        if(listaFunc.isPresent()){
            Funcionario funcionarioQueExiste = listaFunc.get();
            funcDao.delete(funcionarioQueExiste);
           ResponseEntity.ok().build();
        }
      ResponseEntity.notFound().build();
    }




    public void alterarFuncionarioPeloIdInserido(FuncionarioDAO funcionarioDAO, Integer id) throws IdNotFoundException{
        Optional<Funcionario> listaFun =funcDao.findById(id);

        Cargo cargo = buscaEntidadeCargoAtravesDoNomeDoCargo(funcionarioDAO);
        Departamento departamento = buscaEntidadeDepartamentoAtravesDoNomeDoDepartamento(funcionarioDAO);
        if(listaFun.isPresent()){
            Funcionario funcionarioQueEstaPersistidoNoBanco = listaFun.get();
            funcionarioQueEstaPersistidoNoBanco.setNome(funcionarioDAO.getNome());
            funcionarioQueEstaPersistidoNoBanco.setSobreNome(funcionarioDAO.getSobreNome());
            funcionarioQueEstaPersistidoNoBanco.setSalario(funcionarioDAO.getSalario());
            funcionarioQueEstaPersistidoNoBanco.setnDependentes(funcionarioDAO.getnDependentes());
            funcionarioQueEstaPersistidoNoBanco.setEmail(funcionarioDAO.getEmail());
            funcionarioQueEstaPersistidoNoBanco.setCargo(cargo);
            funcionarioQueEstaPersistidoNoBanco.setDepartamento(departamento);

            funcDao.save(funcionarioQueEstaPersistidoNoBanco);
            ResponseEntity.ok().build();

        }
        ResponseEntity.notFound().build();

    }







    public FuncionarioDAO buscarCamposOsCamposDosFuncionariosESetarElesNoMetodo(Funcionario funcionario, Optional<Cargo>cargo, Optional<Departamento>departemento){

        FuncionarioDAO funcTAO = new FuncionarioDAO();
        Optional<Cargo> verSeCargoExiste = cargo;
        if(verSeCargoExiste.isPresent()){
            Cargo cargoVer = verSeCargoExiste.get();
            funcTAO.setCargo(cargoVer.getCargo());
        }
        Optional<Departamento> verSeDepartamentoExiste = departemento;
        if(verSeDepartamentoExiste.isPresent()){
            Departamento departamentoVer = verSeDepartamentoExiste.get();
            funcTAO.setDepartamento(departamentoVer.getDepartamento());
        }
        funcTAO.setId(funcionario.getId());
        funcTAO.setNome(funcionario.getNome());
        funcTAO.setSobreNome(funcionario.getSobreNome());
        funcTAO.setEmail(funcionario.getEmail());
        funcTAO.setSalario(funcionario.getSalario());
        funcTAO.setnDependentes(funcionario.getnDependentes());
        return funcTAO;
    }
    public Cargo buscaEntidadeCargoAtravesDoNomeDoCargo(FuncionarioDAO funcionario) {
        String nomeDoCargo = funcionario.getCargo();
        Optional<Cargo> optionalCargo = cargoRepository.findByCargo(nomeDoCargo);
        return optionalCargo.get();

    }
    public Departamento buscaEntidadeDepartamentoAtravesDoNomeDoDepartamento(FuncionarioDAO funcionario) {
        String nomeDoDepartamento = funcionario.getDepartamento();
        Optional<Departamento> optionalDepartamento = departamentoRepository.findByDepartamento(nomeDoDepartamento);
        return optionalDepartamento.get();

    }


















}