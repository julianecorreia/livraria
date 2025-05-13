package br.unipar.programacaoweb.livraria.service;

import br.unipar.programacaoweb.livraria.model.Autor;
import br.unipar.programacaoweb.livraria.model.Livro;
import br.unipar.programacaoweb.livraria.repository.AutorRepository;
import br.unipar.programacaoweb.livraria.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private AutorRepository autorRepository;
    private LivroRepository livroRepository;

    public AutorService(AutorRepository autorRepository, LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }

    @Transactional
    public Autor salvar(Autor autor) {
        for (Livro livro : autor.getLivros()) {
            livro.setAutor(autor);
        }
        return autorRepository.save(autor);
    }

    public void excluir(Long id) {
        autorRepository.deleteById(id);
    }

    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor editar(Long id, Autor novo) {
        return null;
    }
}