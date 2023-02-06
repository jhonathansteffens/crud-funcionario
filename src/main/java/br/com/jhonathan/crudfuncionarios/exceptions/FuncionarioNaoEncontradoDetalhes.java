package br.com.jhonathan.crudfuncionarios.exceptions;

public class FuncionarioNaoEncontradoDetalhes extends ErroDetalhes {


    private FuncionarioNaoEncontradoDetalhes() {
    }

    public static final class FuncionarioNaoEncontradoDetalhesBuilder {
        private String titulo;
        private int status;
        private String detalhes;
        private long timestamp;

        private FuncionarioNaoEncontradoDetalhesBuilder() {
        }

        public static FuncionarioNaoEncontradoDetalhesBuilder novoBuilder() {
            return new FuncionarioNaoEncontradoDetalhesBuilder();
        }

        public FuncionarioNaoEncontradoDetalhesBuilder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public FuncionarioNaoEncontradoDetalhesBuilder status(int status) {
            this.status = status;
            return this;
        }

        public FuncionarioNaoEncontradoDetalhesBuilder detalhes(String detalhes) {
            this.detalhes = detalhes;
            return this;
        }

        public FuncionarioNaoEncontradoDetalhesBuilder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public FuncionarioNaoEncontradoDetalhes build() {
            FuncionarioNaoEncontradoDetalhes funcionarioNaoEncontradoDetalhes = new FuncionarioNaoEncontradoDetalhes();
            funcionarioNaoEncontradoDetalhes.setTimestamp(timestamp);
            funcionarioNaoEncontradoDetalhes.setStatus(status);
            funcionarioNaoEncontradoDetalhes.setDetalhes(detalhes);
            funcionarioNaoEncontradoDetalhes.setTitulo(titulo);
            return funcionarioNaoEncontradoDetalhes;
        }
    }
}
