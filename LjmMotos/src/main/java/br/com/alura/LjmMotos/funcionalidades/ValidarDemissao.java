package br.com.alura.LjmMotos.funcionalidades;

import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.modelo.Funcionario;
import br.com.alura.LjmMotos.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class ValidarDemissao {

    @Autowired
    FuncionarioRepository repository;
    public void validar(Funcionario  funcionario){
        if ( funcionario.getDataEmissao()== null){
            repository.deleteById(funcionario.getId());
            return;
        }

        LocalDate dataAtual = LocalDate.now();
        boolean periodoExperiencia = funcionario.getDataEmissao().isAfter(dataAtual.minusMonths(3));

        if (periodoExperiencia) {
            throw new ValidacaoException("Funcionario está na esperiencia");
        } else {
            funcionario.excluir();
            repository.save(funcionario);
        }
    }
}
