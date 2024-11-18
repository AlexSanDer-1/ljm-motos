package br.com.alura.LjmMotos.funcionalidades.funcionario;

import br.com.alura.LjmMotos.modelo.funcionario.Funcionario;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class VerificarDataEmissao {
    public void verificarData(Funcionario funcionario){
        if (funcionario.getDataEmissao() == null){
            funcionario.setDataEmissao(LocalDate.now());
        }
    }
}
