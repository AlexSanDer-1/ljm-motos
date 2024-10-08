package br.com.alura.LjmMotos.controller;

import br.com.alura.LjmMotos.dto.DadosAtualizacaoFuncionario;
import br.com.alura.LjmMotos.dto.FuncionariosDTO;
import br.com.alura.LjmMotos.dto.FuncionariosDetalhamento;
import br.com.alura.LjmMotos.infra.FuncionarioNotFoundException;
import br.com.alura.LjmMotos.modelo.Funcionario;
import br.com.alura.LjmMotos.repository.FuncionarioRepository;
import br.com.alura.LjmMotos.service.FuncionarioService;
import br.com.alura.LjmMotos.infra.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("ljm")
public class ljmControler {
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    FuncionarioRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity contratar(@RequestBody @Valid FuncionariosDTO dto, UriComponentsBuilder uriBuilder) {
        try {

           Funcionario funcionario =  funcionarioService.cadastrar(dto);
            var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(funcionario.getId()).toUri();

            return ResponseEntity.created(uri).body(new FuncionariosDetalhamento(funcionario));
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Page<FuncionariosDetalhamento>> listaFuncionarios(Pageable pageable) {
        try {
             var page = funcionarioService.listarFuncionario(pageable);
            return ResponseEntity.ok(page);
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/ex-funcionarios")
    @Transactional
    public ResponseEntity<Page<FuncionariosDetalhamento>> listarExFuncionarios(Pageable pageable){
        try {
            var page = funcionarioService.listarExFuncionarios(pageable);
            return ResponseEntity.ok(page);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PutMapping("/{id}")
    public  ResponseEntity<?> atualizar(@PathVariable Long id,@RequestBody @Valid DadosAtualizacaoFuncionario dados ) {
        try {
          var funcionario =  funcionarioService.atualizar(id, dados);
            return ResponseEntity.ok(new FuncionariosDetalhamento(funcionario));
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (FuncionarioNotFoundException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?>  demitir(@PathVariable Long id){
         try{
             funcionarioService.demitir(id);
             return ResponseEntity.noContent().build();
         }catch (ValidacaoException e){
             return ResponseEntity.badRequest().body(e.getMessage());
         }catch (EntityNotFoundException e){
             return  ResponseEntity.notFound().build();
         }
    }

     @GetMapping("/{id}")
    public ResponseEntity  detalhar(@PathVariable Long id){
        try{
            Funcionario funcionario = funcionarioService.detalhar(id);
            return ResponseEntity.ok(new FuncionariosDetalhamento(funcionario));
        }catch (ValidacaoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (EntityNotFoundException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
