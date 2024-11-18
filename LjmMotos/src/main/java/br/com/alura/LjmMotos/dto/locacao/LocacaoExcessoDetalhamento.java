package br.com.alura.LjmMotos.dto.locacao;

import br.com.alura.LjmMotos.modelo.locacao.LocacaoExceso;
import br.com.alura.LjmMotos.modelo.produto.Produto;

public record LocacaoExcessoDetalhamento(Long produtoId, Long idExceso, String locacao,
                                         Integer limiteArmazenamento, Integer quantidade) {

    public LocacaoExcessoDetalhamento(Produto produto, LocacaoExceso exceso) {
        this(produto.getId(), exceso.getId(),
                String.format("Locação C%s %s %s%s ", exceso.getPartilheira(), exceso.getDirecaoPartilheira(),
                        exceso.getNivel(), exceso.getColuna())
                ,exceso.getLimiteArmazenamento(),exceso.getQuantidade());
    }
}
