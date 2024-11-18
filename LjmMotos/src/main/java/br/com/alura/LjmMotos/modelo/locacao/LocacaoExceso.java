package br.com.alura.LjmMotos.modelo.produto;

import br.com.alura.LjmMotos.dto.LocaoExcessoDto;
import br.com.alura.LjmMotos.dto.produto.ProdutoDto;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "locacao_excesso")
@Entity(name = "Locacao_Excesso")
public class LocacaoExceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partilheira;
    private String direcaoPartilheira;
    private String nivel;
    private String coluna;
    private Integer limiteArmazenamento;
    private Integer quantidade;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    public LocacaoExceso(LocaoExcessoDto dto,Produto produto){
        this.partilheira = dto.partilheira();
        this.direcaoPartilheira = dto.direcaoPartilheira();
        this.nivel = dto.nivel();
        this.coluna = dto.coluna();
        this.limiteArmazenamento = dto.limiteArmazenamento();
        this.quantidade = dto.quantidade();
    }


}