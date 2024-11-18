package br.com.alura.LjmMotos.funcionalidades.produto;


import br.com.alura.LjmMotos.modelo.produto.PrecoProduto;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class PorcentagemImposto {


    public void porcentamImposto(PrecoProduto preco) {
        ZoneId regiao = ZoneId.systemDefault();
        if (regiao.equals(ZoneId.of("America/Bahia"))) {
          preco.setIcms(0.19);
        } else if (regiao.equals(ZoneId.of("America/Sao_Paulo"))) {
           preco.setIcms(0.5);
        } else if (regiao.equals(ZoneId.of("America/Fortaleza"))) {
            preco.setIcms(0.2);
        } else if (regiao.equals(ZoneId.of("America/Recife"))) {
           preco.setIcms(0.25);
        }
    }

}
