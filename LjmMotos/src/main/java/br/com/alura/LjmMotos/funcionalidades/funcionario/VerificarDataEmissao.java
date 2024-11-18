package br.com.alura.LjmMotos.funcionalidades;

import br.com.alura.LjmMotos.modelo.Funcionario;
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
