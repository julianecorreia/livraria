package br.unipar.programacaoweb.livraria.controller;

import br.unipar.programacaoweb.livraria.model.Livro;
import br.unipar.programacaoweb.livraria.service.LivroService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/livro/listar")
    public ResponseEntity<List<Livro>> listarLivros() {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.listarTodos());
    }

    @GetMapping("/livro/listar/{id}")
    public ResponseEntity<Livro> listarLivro(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.buscarPorId(id));
    }

    @PostMapping("/livro/salvar")
    public ResponseEntity<Livro> criarLivro(@Valid @RequestBody Livro livro) {
        Livro livroNovo = livroService.salvar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroNovo);
    }


}
