package br.com.alura.LjmMotos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDto(@NotBlank String nome, @NotNull Double valorVarejo,@NotNull ,@NotNull Integer quantidade, @NotBlank String descricao) {
}
