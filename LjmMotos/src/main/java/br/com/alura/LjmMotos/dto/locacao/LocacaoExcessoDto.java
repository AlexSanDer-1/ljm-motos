package br.com.alura.LjmMotos.dto.locacao;

import br.com.alura.LjmMotos.dto.produto.ProdutoDtoId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LocacaoExcessoDto(@NotNull ProdutoDtoId produto, LocacaoDtoId locacao, @NotBlank String partilheira,
                                @NotBlank String direcaoPartilheira, @NotBlank String nivel, @NotBlank String coluna,
                                @NotNull Integer limiteArmazenamento, Integer quantidade) {
}
