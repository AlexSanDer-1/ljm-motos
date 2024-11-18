package br.com.alura.LjmMotos.repository;

import br.com.alura.LjmMotos.modelo.produto.EstoqueCima;
import br.com.alura.LjmMotos.modelo.produto.Locacao;
import br.com.alura.LjmMotos.modelo.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EstoqueCimaRepository extends JpaRepository<EstoqueCima,Long> {
    Optional<Produto> findByLocacaoIdAndQuantidadeGreaterThanLimiteArmazenamento(Long locacaoId);


}
