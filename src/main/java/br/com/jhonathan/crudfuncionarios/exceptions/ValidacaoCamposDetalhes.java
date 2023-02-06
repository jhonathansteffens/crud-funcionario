package br.com.jhonathan.crudfuncionarios.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidacaoCamposDetalhes extends ErroDetalhes{
    private String campo;
    private String mensagemCampo;


    public static final class Builder {
        private String titulo;
        private int status;
        private String detalhes;
        private long timestamp;

        private String campo;

        private String mensagemCampo;

        private Builder() {
        }

        public static Builder novoBuilder() {
            return new Builder();
        }

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detalhes(String detalhes) {
            this.detalhes = detalhes;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder campo(String campo) {
            this.campo = campo;
            return this;
        }

        public Builder mensagemCampo(String mensagemCampo) {
            this.mensagemCampo = mensagemCampo;
            return this;
        }

        public ValidacaoCamposDetalhes build() {
            ValidacaoCamposDetalhes validacaoCamposDetalhes = new ValidacaoCamposDetalhes();
            validacaoCamposDetalhes.setTimestamp(timestamp);
            validacaoCamposDetalhes.setStatus(status);
            validacaoCamposDetalhes.setDetalhes(detalhes);
            validacaoCamposDetalhes.setTitulo(titulo);
            validacaoCamposDetalhes.setCampo(campo);
            validacaoCamposDetalhes.setMensagemCampo(mensagemCampo);
            return validacaoCamposDetalhes;
        }
    }
}
