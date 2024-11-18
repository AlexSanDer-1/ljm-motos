package br.com.alura.LjmMotos.funcionalidades.locacao;

import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.modelo.produto.Produto;
import br.com.alura.LjmMotos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FiltrarProduto {
    @Autowired
    private ProdutoRepository repository;
    public Produto filtrar(Long id){

       return   repository.findByIdAndExcessoGreaterThan(id,0)
                .orElseThrow(() -> new ValidacaoException("Produto não possui excesso"));

    }
}
