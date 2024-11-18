package br.com.alura.LjmMotos.modelo.produto;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Table(name = "precosVendaProdutos")
@Entity(name =  "PrecoVendaProduto")
public class Preco{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double custoProduto;
    private double ICMS;
    private double margemDeLucro;
    @ManyToOne
    @OneToMany(mappedBy = "preco",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Produto produto;




}

