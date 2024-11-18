package br.com.alura.LjmMotos.dto.locacao;

import br.com.alura.LjmMotos.modelo.locacao.Locacao;
import br.com.alura.LjmMotos.modelo.locacao.LocacaoExceso;
import br.com.alura.LjmMotos.modelo.locacao.NivelEstoque;
import br.com.alura.LjmMotos.modelo.produto.Produto;

public record LocacaoDetalhamento(Long idProduto, Long idLocacao, String locacao, Integer excesso,
                                  Integer limiteArmazenamento, Integer quantidade, NivelEstoque andarEstoque) {

    public LocacaoDetalhamento(Produto produto, Locacao locacao) {
        this(produto.getId(), locacao.getId(),
                String.format("Locação C%d %s %s%d ", locacao.getPartilheira(), locacao.getDirecaoPartilheira(),
                        locacao.getNivel(), locacao.getColuna()),
                produto.getExcesso(),locacao.getLimiteArmazenamento(), locacao.getQuantidade(),locacao.getNivelEstoque());
    }
}
