package br.com.alura.LjmMotos.service;

import br.com.alura.LjmMotos.dto.DadosAtualizacaoFuncionario;
import br.com.alura.LjmMotos.dto.FuncionariosDTO;
import br.com.alura.LjmMotos.dto.FuncionariosDetalhamento;
import br.com.alura.LjmMotos.funcionalidades.AtualizarDadosFuncionario;
import br.com.alura.LjmMotos.funcionalidades.CalculoSalario;
import br.com.alura.LjmMotos.funcionalidades.ValidacaoCadastroFuncionario;
import br.com.alura.LjmMotos.funcionalidades.ValidarDemissao;
import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.modelo.Funcionario;
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
    private  ValidarDemissao validarDemissao;

    public Funcionario cadastrar(FuncionariosDTO dto) {

        Funcionario funcionario = new Funcionario(dto);

        validarCadastro.validar(dto);

        calculoSalario.validar(funcionario);
      return   repository.save(funcionario);
    }

    public Page<FuncionariosDetalhamento> listarFuncionario(Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable)
                .map(FuncionariosDetalhamento::new);
    }

    public Page<FuncionariosDetalhamento> listarExFuncionarios(Pageable pageable) {
        return repository.findAllByAtivoFalse(pageable)
                .map(FuncionariosDetalhamento::new);
    }

    public Funcionario atualizar(Long id, DadosAtualizacaoFuncionario dados) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Funcionario não encontrado"));
        atualizarDados.validar(funcionario,dados);
      return   repository.save(funcionario);
    }

    public void demitir(Long id) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Funcionario não encontrado"));

        validarDemissao.validar(funcionario);

    }

    public Funcionario detalhar(Long id){
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Funcionario não encontrado"));
        return  funcionario;
    }



}
