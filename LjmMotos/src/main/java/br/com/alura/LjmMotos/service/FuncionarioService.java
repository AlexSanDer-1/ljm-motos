package br.com.alura.LjmMotos.service;

import br.com.alura.LjmMotos.dto.funcionario.DadosAtualizacaoFuncionario;
import br.com.alura.LjmMotos.dto.funcionario.FuncionarioDemissaoDTO;
import br.com.alura.LjmMotos.dto.funcionario.FuncionariosDTO;
import br.com.alura.LjmMotos.dto.funcionario.FuncionariosDetalhamento;
import br.com.alura.LjmMotos.funcionalidades.funcionario.*;
import br.com.alura.LjmMotos.modelo.funcionario.Funcionario;
import br.com.alura.LjmMotos.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;
    @Autowired
    private CalculoSalario calculoSalario;
    @Autowired
    private AtualizarDadosFuncionario atualizarDados;
    @Autowired
    private ValidacaoCadastroFuncionario validarCadastro;
    @Autowired
    private ValidarDemissao validarDemissao;
    @Autowired
    private VerificarDataEmissao verificar;
    @Autowired
    private CarregarFuncionario carregar;

    public Funcionario cadastrar(FuncionariosDTO dto) {

        Funcionario funcionario = new Funcionario(dto);

        validarCadastro.validar(dto);
        verificar.verificarData(funcionario);
        calculoSalario.calcular(funcionario);
        return repository.save(funcionario);
    }

    public Page<FuncionariosDetalhamento> listarFuncionario(Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable)
                .map(FuncionariosDetalhamento::new);
    }

    public Page<FuncionariosDetalhamento> listarExFuncionarios(Pageable pageable) {
        return repository.findAllByAtivoFalse(pageable)
                .map(FuncionariosDetalhamento::new);
    }

    public Funcionario atualizar(DadosAtualizacaoFuncionario dto) {
        Funcionario funcionario = atualizarDados.atualizarFuncionario(dto);
        return repository.save(funcionario);
    }

    public void demitir(FuncionarioDemissaoDTO dto) {

        validarDemissao.validar(dto);

    }

    public Funcionario detalhar(Long id) {
        Funcionario funcionario = carregar.carregar(id);
        return funcionario;
    }

}
