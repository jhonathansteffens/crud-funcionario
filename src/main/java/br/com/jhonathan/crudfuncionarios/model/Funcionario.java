package br.com.jhonathan.crudfuncionarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Funcionario {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 30)
    @NotEmpty(message = "O campo nome é obrigatório")
    @Size(min = 2, max = 30)
    private String nome;

    @Size(max = 50)
    @Column(name = "SOBRENOME", length = 50)
    private String sobrenome;

    @Column(name = "EMAIL", length = 100)
    @Email(message = "Digite um email válido")
    @Size(max = 100)
    private String email;

    @Column(name = "NIS")
    private Long Nis;
}
