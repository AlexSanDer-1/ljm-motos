package br.com.alura.LjmMotos.modelo.locacao;

import br.com.alura.LjmMotos.dto.locacao.LocacaoDto;
import br.com.alura.LjmMotos.modelo.produto.Produto;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "locacao")
@Entity(name = "Locacao")
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer partilheira;
    private String direcaoPartilheira;
    private String nivel;
    private Integer coluna;
    private Integer limiteArmazenamento;
    private Integer quantidade;
    @Enumerated(EnumType.STRING)
    private NivelEstoque nivelEstoque;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;


    public Locacao(LocacaoDto dto, Produto produto) {
        this.partilheira = dto.partilheira();
        this.direcaoPartilheira = dto.direcaoPartilheira();
        this.nivel = dto.nivel();
        this.coluna = dto.coluna();
        this.limiteArmazenamento = dto.limiteArmazenamento();
        this.quantidade = dto.quantidade();
    }


}
