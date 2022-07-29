package br.com.alura.linguagens.api.controller;

import br.com.alura.linguagens.api.model.Linguagem;
import br.com.alura.linguagens.api.repository.LinguagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/linguagens")
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;


    //CRUD
    @GetMapping
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }

    @GetMapping("/{id}")
    public Optional<Linguagem> obterLinguagensId(@PathVariable String id) {
        Optional<Linguagem> linguagens = repositorio.findById(id);
        return linguagens;
    }

    @PostMapping
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    }

    @PutMapping
    public Linguagem alterarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repositorio.deleteById(id);
    }


}
