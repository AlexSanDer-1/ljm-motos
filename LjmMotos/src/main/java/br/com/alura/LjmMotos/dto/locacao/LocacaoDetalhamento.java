package br.com.alura.LjmMotos.dto.produto;

import br.com.alura.LjmMotos.modelo.locacao.Locacao;
import br.com.alura.LjmMotos.modelo.produto.Produto;

public record LocacaoDetalhamento(Long idProduto,int excesso,Long idLocacao, String partilheira, String direcaoPartilheira, String nivel,
                                  String coluna, Integer limiteArmazenamento, Integer quantidade) {

    public LocacaoDetalhamento(Produto produto, Locacao locacao) {
        this(produto.getId(),produto.getExcesso(),locacao.getId(), locacao.getPartilheira(), locacao.getDirecaoPartilheira(), locacao.getNivel(), locacao.getColuna(),
                locacao.getLimiteArmazenamento(), locacao.getQuantidade());
    }
}
