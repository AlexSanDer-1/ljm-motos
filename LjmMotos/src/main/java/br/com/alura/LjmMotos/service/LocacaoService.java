package br.com.alura.LjmMotos.service;

import br.com.alura.LjmMotos.dto.locacao.LocacaoDto;
import br.com.alura.LjmMotos.dto.locacao.LocacaoExcessoDto;
import br.com.alura.LjmMotos.funcionalidades.locacao.*;
import br.com.alura.LjmMotos.funcionalidades.produto.CarregarProduto;
import br.com.alura.LjmMotos.funcionalidades.produto.ValidarProduto;
import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.infra.Validar;
import br.com.alura.LjmMotos.modelo.locacao.Locacao;
import br.com.alura.LjmMotos.modelo.locacao.LocacaoExceso;
import br.com.alura.LjmMotos.modelo.locacao.NivelEstoque;
import br.com.alura.LjmMotos.modelo.produto.Produto;
import br.com.alura.LjmMotos.repository.LocacaoExcessoRepository;
import br.com.alura.LjmMotos.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoService {
    @Autowired
    private LocacaoRepository locacaoRepository;
    @Autowired
    private CarregarProduto carregarProduto;
    @Autowired
    private VerificarExcesso verificarExcesso;
    @Autowired
    private CarregarLocacao carregarLocacao;
    @Autowired
    private LocacaoExcessoRepository excessoRepository;
    @Autowired
    private FiltrarProduto filtrarProduto;
    @Autowired
    private DelimitarLocacao delimitar;
    @Autowired
    private LocacaoReservada locacaoReservada;
    @Autowired
    private ValidarLocacao validarLocacao;


    public Locacao alocarProduto(LocacaoDto dto) {
        Produto produto = carregarProduto.carregar(dto.produto().id());
        Locacao locacao = new Locacao(dto, produto);

        //Define nivel estoque
        var nivelEstoque = delimitar.demilitarPartilheria(locacao);
        locacao.setNivelEstoque(nivelEstoque);
        //Não permita locações repetidas
        validarLocacao.validar(dto);

        //Define excesso com limite ultrapassado
        var excesso = verificarExcesso.verificar(dto);
        produto.setExcesso(excesso);

        return locacaoRepository.save(locacao);
    }


    public LocacaoExceso alocarExcessoProduto(LocacaoExcessoDto dto) {
        //Filtra somente produto possuem excesso
        Produto produto = filtrarProduto.filtrar(dto.produto().id());

        LocacaoExceso locacaoExceso = new LocacaoExceso(dto, produto);
        //Quantidade em excesso
        var excesso = produto.getExcesso();
        locacaoExceso.setQuantidade(excesso);

        return excessoRepository.save(locacaoExceso);
    }
}
