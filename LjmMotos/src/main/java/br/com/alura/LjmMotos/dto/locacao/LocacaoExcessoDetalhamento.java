package br.com.alura.LjmMotos.dto;

import br.com.alura.LjmMotos.dto.produto.ProdutoDto;
import br.com.alura.LjmMotos.modelo.locacao.Locacao;
import br.com.alura.LjmMotos.modelo.locacao.LocacaoExceso;
import br.com.alura.LjmMotos.modelo.produto.Produto;
import br.com.alura.LjmMotos.modelo.produto.TipoValor;

public record LocacaoExcessoDetalhamento(Integer codigo, Long idExceso, String partilheira, String direcaoPartilheira,
                                         String nivel, String coluna, Integer limiteArmazenamento, Integer quantidade) {

    public LocacaoExcessoDetalhamento(Produto produto,LocacaoExceso exceso){
        this(produto.getCodigo(),exceso.getId(), exceso.getPartilheira(),exceso.getDirecaoPartilheira(), exceso.getNivel(),
                exceso.getColuna(), exceso.getLimiteArmazenamento(),exceso.getQuantidade());
    }
}
