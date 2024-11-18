package br.com.alura.LjmMotos.funcionalidades;

import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.modelo.Funcionario;
import br.com.alura.LjmMotos.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarregarFuncionario {
    @Autowired
    public FuncionarioRepository repository;

    public Funcionario carregarFuncionario(Long id){

          return  repository.findById(id)
                  .orElseThrow( ()-> new ValidacaoException("Funcionario não encontrado"));

    }
}
