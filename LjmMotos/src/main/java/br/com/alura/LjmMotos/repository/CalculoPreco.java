package br.com.alura.LjmMotos.repository;

import br.com.alura.LjmMotos.dto.produto.ProdutoDto;

public interface CalculoPreco {

      double  calcular(ProdutoDto dto);
}
