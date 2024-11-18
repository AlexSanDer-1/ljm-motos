package br.com.alura.LjmMotos.funcionalidades.produto;

import br.com.alura.LjmMotos.dto.produto.ProdutoDto;
import br.com.alura.LjmMotos.modelo.produto.PrecoProduto;
import br.com.alura.LjmMotos.modelo.produto.TipoValor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MargemLucro {

    public void margemLucro(PrecoProduto preco, ProdutoDto dto) {
        if (dto.tipoValor() == TipoValor.ATACADO) {
            preco.setMargemDeLucro(0.30);
        } else if (dto.tipoValor() == TipoValor.VAREJO) {
            preco.setMargemDeLucro(0.10);
        }
    }
}
