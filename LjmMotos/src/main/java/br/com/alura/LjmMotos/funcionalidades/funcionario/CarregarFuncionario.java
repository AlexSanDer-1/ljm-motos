package br.com.alura.LjmMotos.funcionalidades.funcionario;

import br.com.alura.LjmMotos.infra.Carregar;
import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.modelo.funcionario.Funcionario;
import br.com.alura.LjmMotos.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarregarFuncionario  implements Carregar<Funcionario> {
    @Autowired
    public FuncionarioRepository repository;

    public Funcionario carregar(Long id){

          return  repository.findById(id)
                  .orElseThrow( ()-> new ValidacaoException("Funcionario não encontrado"));

    }
}
