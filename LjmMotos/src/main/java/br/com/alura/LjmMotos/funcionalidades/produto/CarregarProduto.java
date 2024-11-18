package br.com.alura.LjmMotos.funcionalidades.produto;

import br.com.alura.LjmMotos.infra.Carregar;
import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.modelo.produto.Produto;
import br.com.alura.LjmMotos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarregarProduto implements Carregar<Produto> {
    @Autowired
    private ProdutoRepository repository;

    public Produto carregar(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Produto não encontrado"));

    }
}
