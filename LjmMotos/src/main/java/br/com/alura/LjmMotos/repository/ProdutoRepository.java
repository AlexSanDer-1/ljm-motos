package br.com.alura.LjmMotos.repository;

import br.com.alura.LjmMotos.modelo.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    boolean existsByCodigo(Integer codigo);

    Optional<Produto> findByIdAndExcessoGreaterThan(Long id, int excesso);


}
