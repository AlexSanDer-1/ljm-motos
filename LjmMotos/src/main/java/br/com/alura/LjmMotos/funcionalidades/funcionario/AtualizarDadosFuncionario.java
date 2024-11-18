package br.com.alura.LjmMotos.funcionalidades;

import br.com.alura.LjmMotos.dto.DadosAtualizacaoFuncionario;
import br.com.alura.LjmMotos.modelo.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AtualizarDadosFuncionario{
    @Autowired
    private CalculoSalario calculoSalario;
    @Autowired
    private CarregarFuncionario carregar;
    public Funcionario atualizarFuncionario(DadosAtualizacaoFuncionario dto) {
         Funcionario funcionario = carregar.carregarFuncionario(dto.id());
        if (dto.nome() != null) {
            funcionario.setNome(dto.nome());
        }
        if (dto.idade() != null) {
            funcionario.setIdade(dto.idade());
        }
        if (dto.cargo() != null) {
            funcionario.setCargo(dto.cargo());
            calculoSalario.calcular(funcionario);
        }if (dto.dataEmissao() == null){
            funcionario.setDataEmissao(LocalDate.now());
        }
        return funcionario;
    }
}
