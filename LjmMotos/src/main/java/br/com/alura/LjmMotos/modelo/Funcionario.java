package br.com.alura.LjmMotos.modelo;

import br.com.alura.LjmMotos.dto.DadosAtualizacaoFuncionario;
import br.com.alura.LjmMotos.dto.FuncionariosDTO;
import br.com.alura.LjmMotos.dto.FuncionariosDetalhamento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Table(name = "funcionarios")
@Entity(name =  "Funcionario")
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

    public Funcionario() {
    }

    public Long getId() {
        return id;
    }

    public Funcionario(FuncionariosDTO dto){
        this.ativo = true;
        this.nome = dto.nome();
        this.idade = dto.idade();
        this.cargo = dto.cargo();
        this.dataEmissao = dto.dataEmissao();
     }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmisao) {
        this.dataEmissao = dataEmisao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


    public void excluir() {
        this.ativo = false;
    }
}
