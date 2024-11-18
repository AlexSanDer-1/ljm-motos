package br.com.alura.LjmMotos.dto.funcionario;

import br.com.alura.LjmMotos.modelo.funcionario.Cargo;

import java.time.LocalDate;

public record DadosAtualizacaoFuncionario(Long id, String nome, Integer idade,Cargo cargo,LocalDate dataEmissao) {


}
