package br.com.jhonathan.crudfuncionarios.controller;

import br.com.jhonathan.crudfuncionarios.dao.FuncionarioDao;
import br.com.jhonathan.crudfuncionarios.exceptions.FuncionarioNaoEncontradoException;
import br.com.jhonathan.crudfuncionarios.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
@CrossOrigin(origins = "http://localhost:4200")
public class FuncionarioController {

    @Autowired
    FuncionarioDao funcionarioDao;

    @RequestMapping(method = RequestMethod.GET)
    public List<Funcionario> buscarTodosFuncionarios() {
        return funcionarioDao.findAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> cadastrarFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioDao.save(funcionario);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarFuncionario(@PathVariable("id") Long id) {
        Optional<Funcionario> funcionario = funcionarioDao.findFuncionarioById(id);
        if (funcionario.isPresent())
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        else
            throw new FuncionarioNaoEncontradoException("O funcionario com o id: " + id + " não foi encontrado");
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> atualizarFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioDao.save(funcionario);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarFuncionario(@PathVariable("id") Long id) {
        funcionarioDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
