package br.com.alura.LjmMotos.funcionalidades.funcionario;

import br.com.alura.LjmMotos.dto.funcionario.FuncionarioDemissaoDTO;
import br.com.alura.LjmMotos.infra.ValidacaoException;
import br.com.alura.LjmMotos.infra.Validar;
import br.com.alura.LjmMotos.modelo.funcionario.Funcionario;
import br.com.alura.LjmMotos.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class ValidarDemissao implements Validar<FuncionarioDemissaoDTO> {

    @Autowired
    private FuncionarioRepository repository;
    @Autowired
    private CarregarFuncionario carregar;
    public void validar(FuncionarioDemissaoDTO dto){

        Funcionario funcionario = carregar.carregar(dto.id());

        if ( dto.dataEmissao() == null){
            repository.deleteById(dto.id());
            return;
        }

        LocalDate dataAtual = LocalDate.now();
        boolean periodoExperiencia = dto.dataEmissao().isAfter(dataAtual.minusMonths(3));

        if (periodoExperiencia) {
            throw new ValidacaoException("Funcionario está na esperiencia");
        } else {
            funcionario.excluir();
            repository.save(funcionario);
        }
    }
}
