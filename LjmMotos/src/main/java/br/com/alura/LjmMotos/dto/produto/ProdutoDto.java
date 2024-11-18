package br.com.alura.LjmMotos.dto.produto;

import br.com.alura.LjmMotos.modelo.produto.TipoValor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public record ProdutoDto(Long id, @NotBlank String nome, @NotNull Integer codigo,@NotNull Double preco, String marca,
                         @NotNull Integer quantidade, String descricao, @NotNull TipoValor tipoValor) {
}
