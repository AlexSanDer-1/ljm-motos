package br.com.alura.LjmMotos.funcionalidades.produto;

import br.com.alura.LjmMotos.dto.produto.ProdutoDto;
import br.com.alura.LjmMotos.modelo.produto.PrecoProduto;
import org.springframework.stereotype.Component;

@Component
public class CalcularPrecoProduto {
    public  double  calcularPreco(ProdutoDto dto, PrecoProduto preco){

            double precoFinal = dto.preco() + (dto.preco() * preco.getMargemDeLucro()) + preco.getIcms();
            return  precoFinal;
    }
}
