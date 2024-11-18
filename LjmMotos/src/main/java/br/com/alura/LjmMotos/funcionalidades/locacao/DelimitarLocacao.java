package br.com.alura.LjmMotos.funcionalidades.locacao;

import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.modelo.locacao.Locacao;
import br.com.alura.LjmMotos.modelo.locacao.NivelEstoque;
import org.springframework.stereotype.Component;

@Component
public class DelimitarLocacao {

    public NivelEstoque demilitarPartilheria(Locacao locacao){

        if (locacao.getPartilheira() > 0  && locacao.getPartilheira() <=19){
           return NivelEstoque.ANDAR_BAIXO;
        }
        else if (locacao.getPartilheira() >= 30 &&  locacao.getPartilheira() <= 50 ){
           return  NivelEstoque.ANDAR_CIMA;
        }else {
            throw  new ValidacaoException("Número de partilheiras é  invalido");
        }
    }
}
