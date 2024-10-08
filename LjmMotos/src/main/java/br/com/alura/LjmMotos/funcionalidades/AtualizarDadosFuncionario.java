package br.com.alura.LjmMotos.funcionalidades;

import br.com.alura.LjmMotos.dto.DadosAtualizacaoFuncionario;
import br.com.alura.LjmMotos.modelo.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizarDadosFuncionario {
    @Autowired
    private CalculoSalario calculoSalario;
    public void validar(Funcionario funcionario,DadosAtualizacaoFuncionario dados) {
        if (dados.nome() != null) {
            funcionario.setNome(dados.nome());
        }
        if (dados.idade() != null) {
            funcionario.setIdade(dados.idade());
        }
        if (dados.cargo() != null) {
            funcionario.setCargo(dados.cargo());
        }
        calculoSalario.validar(funcionario);
    }
}
