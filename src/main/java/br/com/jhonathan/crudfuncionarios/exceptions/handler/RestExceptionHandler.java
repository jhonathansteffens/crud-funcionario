package br.com.jhonathan.crudfuncionarios.exceptions.handler;

import br.com.jhonathan.crudfuncionarios.exceptions.FuncionarioNaoEncontradoDetalhes;
import br.com.jhonathan.crudfuncionarios.exceptions.FuncionarioNaoEncontradoException;
import br.com.jhonathan.crudfuncionarios.exceptions.ValidacaoCamposDetalhes;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(FuncionarioNaoEncontradoException.class)
    public ResponseEntity<?> handleFuncionarioNaoEncontradoException(FuncionarioNaoEncontradoException exception) {
        FuncionarioNaoEncontradoDetalhes excecaoBuilder = FuncionarioNaoEncontradoDetalhes.FuncionarioNaoEncontradoDetalhesBuilder
        .novoBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .titulo("Funcionario não encontrado")
                .detalhes(exception.getMessage())
                .build();
        return new ResponseEntity<>(excecaoBuilder, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleCamposException(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        String mensagem = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(","));
            Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
            StringBuilder camposFormatados = new StringBuilder();
            Set<String> campos = new HashSet<>();
            for (ConstraintViolation violation : violations) {
                for (Path.Node node : violation.getPropertyPath()) {
                    campos.add(node.getName());
                }
            }
            campos.forEach(s -> camposFormatados.append(s).append("; "));
        ValidacaoCamposDetalhes excecaoBuilder = ValidacaoCamposDetalhes.Builder
                .novoBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .titulo("Erro ao realizar a requisiçao")
                .detalhes("")
                .campo(String.valueOf(camposFormatados))
                .mensagemCampo(mensagem)
                .build();
        return new ResponseEntity<>(excecaoBuilder, HttpStatus.BAD_REQUEST);
    }
}
