package br.com.alura.LjmMotos.repository;

import br.com.alura.LjmMotos.modelo.locacao.Locacao;
import br.com.alura.LjmMotos.modelo.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao,Long> {

    boolean existsByProduto(Produto produto);


}
