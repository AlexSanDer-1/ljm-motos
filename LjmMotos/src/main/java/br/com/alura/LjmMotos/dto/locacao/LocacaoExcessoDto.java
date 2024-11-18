package br.com.alura.LjmMotos.dto.produto;

import br.com.alura.LjmMotos.dto.LocacaoDtoId;
import br.com.alura.LjmMotos.dto.produto.ProdutoDtoId;
import br.com.alura.LjmMotos.modelo.locacao.Locacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LocacaoExcessoDto(@NotNull Long  produtoId,Long locacaoId,@NotBlank String partilheira,
                                @NotBlank String direcaoPartilheira, @NotBlank String nivel, @NotBlank String coluna,
                                @NotNull Integer limiteArmazenamento, Integer quantidade) {
}
