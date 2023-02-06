package br.com.jhonathan.crudfuncionarios.dao;

import br.com.jhonathan.crudfuncionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioDao extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findFuncionarioById(Long id);
}
