package br.com.alura.LjmMotos.modelo.produto;

import br.com.alura.LjmMotos.dto.produto.ProdutoDto;
import br.com.alura.LjmMotos.modelo.locacao.Locacao;
import br.com.alura.LjmMotos.modelo.locacao.LocacaoExceso;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "produtos")
@Entity(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer codigo;
    private Double preco;
    private Integer quantidade;
    private String descricao;
    private String marca;
    private Integer excesso;
    @Enumerated(EnumType.STRING)
    private TipoValor tipoValor;


    public Produto(ProdutoDto dto) {
        this.nome = dto.nome();
        this.codigo = dto.codigo();
        this.marca = dto.marca();
        this.preco = dto.preco();
        this.quantidade = dto.quantidade();
        this.descricao = dto.descricao();
        this.tipoValor = dto.tipoValor();
    }
}
