package br.com.alura.LjmMotos.dto.produto;

import br.com.alura.LjmMotos.dto.produto.ProdutoDto;
import br.com.alura.LjmMotos.modelo.produto.Produto;
import br.com.alura.LjmMotos.modelo.produto.TipoValor;

public record ProdutoDetalhamento(Long idProduto, String nome,Integer codigo,Double preco, Integer quantidade, String descricao,
                                  String marca, TipoValor tipoValor) {
    public ProdutoDetalhamento(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getCodigo(),produto.getPreco(),produto.getQuantidade(), produto.getDescricao(),
                produto.getMarca(),produto.getTipoValor());
    }
}
