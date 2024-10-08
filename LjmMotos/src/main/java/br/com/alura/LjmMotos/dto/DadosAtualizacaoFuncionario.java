package br.com.alura.LjmMotos.dto;

import br.com.alura.LjmMotos.modelo.Cargo;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoFuncionario(@NotNull Long id, String nome, Integer idade,Cargo cargo,LocalDate dataEmissao) {

}
