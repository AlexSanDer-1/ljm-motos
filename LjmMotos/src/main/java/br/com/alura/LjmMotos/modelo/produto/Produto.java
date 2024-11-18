package br.com.alura.LjmMotos.modelo;

import br.com.alura.LjmMotos.dto.ProdutoDto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer quantidade;
    private String descricao;
    private String marca;
    private Double valorAtacado;
    private Double varlorVarejo;


    public Produto(ProdutoDto dto) {
        this.nome = dto.nome();
        this.quantidade = dto.quantidade();
        this.descricao = dto.descricao();
        this.valorAtacado= dto.
    }
}
