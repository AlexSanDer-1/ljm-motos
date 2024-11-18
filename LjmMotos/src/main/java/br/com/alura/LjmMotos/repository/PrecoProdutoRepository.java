package br.com.alura.LjmMotos.repository;

import br.com.alura.LjmMotos.modelo.produto.PrecoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrecoProdutoRepository extends JpaRepository<PrecoProduto,Long> {
}
