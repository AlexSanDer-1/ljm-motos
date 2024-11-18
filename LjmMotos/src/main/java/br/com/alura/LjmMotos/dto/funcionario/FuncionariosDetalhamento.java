package br.com.alura.LjmMotos.dto.funcionario;

import br.com.alura.LjmMotos.modelo.funcionario.Cargo;
import br.com.alura.LjmMotos.modelo.funcionario.Funcionario;

import java.time.LocalDate;

public record FuncionariosDetalhamento(Long id, String nome, Integer idade, Double salario, Cargo cargo, LocalDate dataEmisao) {
    public  FuncionariosDetalhamento(Funcionario funcionario){
        this(funcionario.getId(),funcionario.getNome(),funcionario.getIdade(),funcionario.getSalario(),funcionario.getCargo(),funcionario.getDataEmissao());
    }
}
