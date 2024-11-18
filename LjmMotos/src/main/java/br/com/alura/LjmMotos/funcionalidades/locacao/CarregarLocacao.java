package br.com.alura.LjmMotos.funcionalidades.locacao;

import br.com.alura.LjmMotos.dto.locacao.LocacaoDto;
import br.com.alura.LjmMotos.infra.Carregar;
import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.modelo.funcionario.Funcionario;
import br.com.alura.LjmMotos.modelo.locacao.Locacao;
import br.com.alura.LjmMotos.modelo.produto.Produto;
import br.com.alura.LjmMotos.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarregarLocacao {
    @Autowired
    private LocacaoRepository repository;

    public Locacao carregar(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Locacao não encontrado"));
    }
}
