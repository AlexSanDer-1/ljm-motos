package br.com.alura.LjmMotos.repository;

import br.com.alura.LjmMotos.dto.FuncionariosDetalhamento;
import br.com.alura.LjmMotos.modelo.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {


    Page<Funcionario> findAllByAtivoTrue(Pageable paginacao);

    Page<Funcionario> findAllByAtivoFalse(Pageable paginacao);
}
