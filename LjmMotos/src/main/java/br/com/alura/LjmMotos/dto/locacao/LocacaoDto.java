package br.com.alura.LjmMotos.dto.locacao;

import br.com.alura.LjmMotos.dto.produto.ProdutoDtoId;
import br.com.alura.LjmMotos.modelo.locacao.NivelEstoque;
import jakarta.validation.constraints.NotNull;

public record LocacaoDto(@NotNull ProdutoDtoId produto,Long id,Integer partilheira, String direcaoPartilheira, String nivel,
                         Integer coluna, Integer limiteArmazenamento, Integer quantidade, NivelEstoque nivelEstoque) {
}
