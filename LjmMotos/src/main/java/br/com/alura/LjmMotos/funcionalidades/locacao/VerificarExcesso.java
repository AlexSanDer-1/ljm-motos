package br.com.alura.LjmMotos.funcionalidades.locacao;

import br.com.alura.LjmMotos.dto.locacao.LocacaoDto;
import org.springframework.stereotype.Component;

@Component
public class VerificarExcesso {
    public int verificar(LocacaoDto dto){

        int quantidade = dto.quantidade();
        int limite = dto.limiteArmazenamento();
        int excesso;
        if (quantidade > limite){
           return  excesso = quantidade - limite;
        }else {
            return excesso = 0;
        }
    }
}
