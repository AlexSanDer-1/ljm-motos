package br.com.alura.LjmMotos.dto.funcionario;

import br.com.alura.LjmMotos.modelo.funcionario.Cargo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FuncionariosDTO(Long id, @NotBlank String nome, @NotNull Integer idade,@NotNull Cargo cargo,LocalDate dataEmissao) {


}
