package br.com.alura.LjmMotos.modelo.funcionario;

import br.com.alura.LjmMotos.dto.funcionario.FuncionariosDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "funcionarios")
@Entity(name =  "Funcionario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nome;
    private Integer idade;
    private  Double salario;
    @Column(name = "data_emisao")
    private LocalDate dataEmissao;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    private Boolean ativo;


    public Funcionario(FuncionariosDTO dto){
        this.ativo = true;
        this.nome = dto.nome();
        this.idade = dto.idade();
        this.cargo = dto.cargo();
        this.dataEmissao = dto.dataEmissao();
     }
    public void excluir() {
        this.ativo = false;
    }
}
