package br.com.alura.LjmMotos.infra;

public class FuncionarioNotFoundException extends  RuntimeException{

    public FuncionarioNotFoundException(String message){
        super(message);
    }
    public FuncionarioNotFoundException(Long id){
        super("Funcionário com ID " + id + "não encontrado");
    }
}
