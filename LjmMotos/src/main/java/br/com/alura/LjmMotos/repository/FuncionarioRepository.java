package br.com.alura.LjmMotos.repository;

import br.com.alura.LjmMotos.modelo.funcionario.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {


    Page<Funcionario> findAllByAtivoTrue(Pageable paginacao);

    Page<Funcionario> findAllByAtivoFalse(Pageable paginacao);
}
