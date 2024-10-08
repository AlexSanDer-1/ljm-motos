package br.com.alura.LjmMotos.funcionalidades;

import br.com.alura.LjmMotos.dto.FuncionariosDTO;
import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.modelo.Funcionario;
import br.com.alura.LjmMotos.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidacaoCadastroFuncionario{
    @Autowired
    private FuncionarioRepository repository;

    public void validar(FuncionariosDTO dto) {
        Funcionario funcionario = new Funcionario();
        if (repository.existsById(dto.id())) {
            throw new ValidacaoException("Funcionario já cadastrado");
        } else if (dto.dataEmissao() == null) {
            funcionario.setDataEmissao(LocalDate.now());
        } if (dto.idade() < 18) {
            throw  new ValidacaoException("Menor de idade");
        }
    }

}
