package br.com.alura.LjmMotos.funcionalidades.locacao;

import br.com.alura.LjmMotos.dto.produto.LocacaoExcessoDTO;
import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.modelo.produto.Locacao;
import br.com.alura.LjmMotos.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarregarLocacao {
    @Autowired
    private LocacaoRepository repository;

    public Locacao carregar(LocacaoExcessoDTO dto){
        return repository.findById(dto.locacao().id())
                .orElseThrow(() -> new ValidacaoException("Locação não existe" + dto.locacao().id()));



    }
}
