package br.com.alura.LjmMotos.funcionalidades.locacao;

import br.com.alura.LjmMotos.dto.locacao.LocacaoDto;
import br.com.alura.LjmMotos.infra.Carregar;
import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.infra.Validar;
import br.com.alura.LjmMotos.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarLocacao  implements Validar<LocacaoDto> {
    @Autowired
    private LocacaoRepository repository;

    public  void validar(LocacaoDto dto){
        if (repository.existsById(dto.id())){
            throw  new ValidacaoException("erro");
        }
    }


}
