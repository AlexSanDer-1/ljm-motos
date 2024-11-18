package br.com.alura.LjmMotos.funcionalidades.locacao;

import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.modelo.produto.Produto;
import br.com.alura.LjmMotos.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocacaoReservada {

    @Autowired
    private LocacaoRepository locacaoRepository;
    public void verificarLocacao(Produto produto){

      if ( locacaoRepository.existsById(produto.getId())){
          throw new ValidacaoException("Locação reservada");
      }
    }
}
