package br.com.alura.LjmMotos.modelo.produto;

import br.com.alura.LjmMotos.dto.produto.LocacaoDto;
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
    private String partilheira;
    private String direcaoPartilheira;
    private String nivel;
    private String coluna;
    private Integer limiteArmazenamento;
    private Integer quantidade;
    private Integer excesso;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;


    public Locacao(Produto produto,LocacaoDto dto) {
        this.partilheira = dto.partilheira();
        this.direcaoPartilheira = dto.direcaoPartilheira();
        this.nivel = dto.nivel();
        this.coluna = dto.coluna();
        this.limiteArmazenamento = dto.limiteArmazenamento();
        this.quantidade = dto.quantidade();
    }
}
