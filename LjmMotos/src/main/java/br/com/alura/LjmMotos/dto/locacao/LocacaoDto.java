package br.com.alura.LjmMotos.dto.produto;

import br.com.alura.LjmMotos.dto.produto.ProdutoDto;
import br.com.alura.LjmMotos.dto.produto.ProdutoDtoId;
import br.com.alura.LjmMotos.modelo.produto.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LocacaoDto(@NotNull ProdutoDtoId produto, @NotBlank String partilheira,
                         @NotBlank String direcaoPartilheira, @NotBlank String nivel, @NotBlank String coluna,
                         @NotNull Integer limiteArmazenamento, @NotNull Integer quantidade){
}
