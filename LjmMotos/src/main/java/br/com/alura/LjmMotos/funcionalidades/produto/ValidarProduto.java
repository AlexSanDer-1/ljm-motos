package br.com.alura.LjmMotos.funcionalidades.produto;

import br.com.alura.LjmMotos.dto.produto.ProdutoDto;
import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarProduto {

    @Autowired
    private ProdutoRepository repository;

    public void validar(ProdutoDto dto) {
        if (repository.existsByCodigo(dto.codigo())){
            throw new ValidacaoException("Produto já cadastrado");
        }
    }
}
