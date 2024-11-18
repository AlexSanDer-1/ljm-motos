package br.com.alura.LjmMotos.modelo.produto;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Table(name = "preco_Produtos")
@Entity(name =  "PrecoProduto")
public class PrecoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double icms;
    private double margemDeLucro;
    private  double precoFinal;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    public PrecoProduto( double precoFinal,double icms, double margemDeLucro, Produto produto) {
        this.icms = icms;
        this.margemDeLucro = margemDeLucro;
        this.produto = produto;
        this.precoFinal = precoFinal;
    }


}

