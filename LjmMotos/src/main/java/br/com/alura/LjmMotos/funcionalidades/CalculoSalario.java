package br.com.alura.LjmMotos.funcionalidades;

import br.com.alura.LjmMotos.dto.FuncionariosDTO;
import br.com.alura.LjmMotos.modelo.Cargo;
import br.com.alura.LjmMotos.modelo.Funcionario;
import br.com.alura.LjmMotos.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculoSalario {

    @Autowired
    private FuncionarioRepository repository;

    public void validar(Funcionario funcionario) {
        if (funcionario.getCargo() == Cargo.ESTOQUE) {
            funcionario.setSalario(1500.0);
        } else if (funcionario.getCargo() == Cargo.SEPARADOR) {
            funcionario.setSalario(2360.0);
        } else if (funcionario.getCargo() == Cargo.CONFERENTE_ENTREGA) {
            funcionario.setSalario(3500.0);
        } else if (funcionario.getCargo() == Cargo.CONFERENTE_VAREJO) {
            funcionario.setSalario(3000.00);
        } else if (funcionario.getCargo() == Cargo.EXPEDICAO) {
            funcionario.setSalario(3100.00);
        } else if (funcionario.getCargo() == Cargo.VENDEDOR) {
            funcionario.setSalario(2500.0);
        }
    }
}
