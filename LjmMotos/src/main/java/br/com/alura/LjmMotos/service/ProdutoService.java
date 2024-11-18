package br.com.alura.LjmMotos.service;

import br.com.alura.LjmMotos.dto.produto.ProdutoDto;
import br.com.alura.LjmMotos.funcionalidades.produto.*;
import br.com.alura.LjmMotos.modelo.produto.PrecoProduto;
import br.com.alura.LjmMotos.modelo.produto.Produto;
import br.com.alura.LjmMotos.repository.PrecoProdutoRepository;
import br.com.alura.LjmMotos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repositoryProduto;
    @Autowired
    private PrecoProdutoRepository precoProdutoRepository;
    @Autowired
    private PorcentagemImposto imposto;
    @Autowired
    private MargemLucro lucro;
    @Autowired
    private CalcularPrecoProduto calcular;
    @Autowired
    private ValidarProduto validarProduto;


    public Produto cadastrarProduto(ProdutoDto dto) {
        Produto produto = new Produto(dto);
        validarProduto.validar(dto);
        PrecoProduto precoProduto = new PrecoProduto();
        imposto.porcentamImposto(precoProduto);
        lucro.margemLucro(precoProduto, dto);

        double precoFinal = calcular.calcularPreco(dto, precoProduto);

        produto.setPreco(precoFinal);

        produto = repositoryProduto.save(produto);
        precoProdutoRepository.save(precoProduto);

        return produto;

    }

}
