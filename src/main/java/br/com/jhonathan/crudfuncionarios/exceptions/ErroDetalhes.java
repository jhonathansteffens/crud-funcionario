package br.com.jhonathan.crudfuncionarios.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroDetalhes {

    private String titulo;
    private int status;
    private String detalhes;
    private long timestamp;
}
