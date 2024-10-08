package br.com.alura.LjmMotos.dto;

import br.com.alura.LjmMotos.modelo.Cargo;
import br.com.alura.LjmMotos.modelo.Funcionario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FuncionariosDetalhamento(Long id, String nome, Integer idade, Double salario, Cargo cargo, LocalDate dataEmisao) {
    public  FuncionariosDetalhamento(Funcionario funcionario){
        this(funcionario.getId(),funcionario.getNome(),funcionario.getIdade(),funcionario.getSalario(),funcionario.getCargo(),funcionario.getDataEmissao());
    }
}
