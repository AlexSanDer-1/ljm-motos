package br.com.alura.LjmMotos.controller;

import br.com.alura.LjmMotos.dto.locacao.*;
import br.com.alura.LjmMotos.dto.produto.*;
import br.com.alura.LjmMotos.funcionalidades.locacao.CarregarLocacao;
import br.com.alura.LjmMotos.funcionalidades.produto.CarregarProduto;
import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.dto.produto.ProdutoDetalhamento;
import br.com.alura.LjmMotos.modelo.locacao.Locacao;
import br.com.alura.LjmMotos.modelo.locacao.LocacaoExceso;
import br.com.alura.LjmMotos.modelo.produto.Produto;
import br.com.alura.LjmMotos.service.LocacaoService;
import br.com.alura.LjmMotos.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("estoque")
public class EstoqueControler {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private LocacaoService locacaoService;
    @Autowired
    private CarregarProduto carregarProduto;
    @Autowired
    private CarregarLocacao carregarLocacao;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrarProduto(@RequestBody @Valid ProdutoDto dto, UriComponentsBuilder uriBuilder) {
        try {
            Produto produto = produtoService.cadastrarProduto(dto);
            var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();

            return ResponseEntity.created(uri).body(new ProdutoDetalhamento(produto));
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/alocar")
    @Transactional
    public ResponseEntity alocarProduto(@RequestBody @Valid LocacaoDto dto, UriComponentsBuilder uriBuilder) {
        try {
            Locacao locacao = locacaoService.alocarProduto(dto);

            var uri = uriBuilder.path("/locacao/{id}").buildAndExpand(locacao.getId()).toUri();

            Produto produto = carregarProduto.carregar(dto.produto().id());
            return ResponseEntity.created(uri).body(new LocacaoDetalhamento(produto, locacao));
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/Excesso")
    @Transactional
    public ResponseEntity alocarExcessoProduto(@RequestBody @Valid LocacaoExcessoDto dto,UriComponentsBuilder uriBuilder) {
        try {
            Produto produto = carregarProduto.carregar(dto.produto().id());
            LocacaoExceso exceso = locacaoService.alocarExcessoProduto(dto);

            var uri = uriBuilder.path("/locacao_excesso/{id}").buildAndExpand(exceso.getId()).toUri();

            return ResponseEntity.created(uri).body(new LocacaoExcessoDetalhamento(produto,exceso));
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }







}
