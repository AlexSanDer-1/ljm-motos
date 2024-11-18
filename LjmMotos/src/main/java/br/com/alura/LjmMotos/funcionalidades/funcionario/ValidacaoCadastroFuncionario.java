package br.com.alura.LjmMotos.funcionalidades;

import br.com.alura.LjmMotos.dto.FuncionariosDTO;
import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoCadastroFuncionario {
    @Autowired
    private FuncionarioRepository repository;

    public void validar(FuncionariosDTO dto) {
        if (repository.existsById(dto.id())) {
            throw new ValidacaoException("Funcionario já cadastrado");
        }
         if (dto.idade() < 18) {
            throw  new ValidacaoException("Menor de idade");
        }
    }
}






