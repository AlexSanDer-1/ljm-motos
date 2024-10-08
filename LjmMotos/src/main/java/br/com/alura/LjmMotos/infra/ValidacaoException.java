package br.com.alura.LjmMotos.infra;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
    public ValidacaoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
