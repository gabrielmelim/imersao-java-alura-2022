package br.com.alura.linguagens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@CrossOrigin(origins = {"http://192.168.1.3/"}, allowedHeaders="Access-Control-Allow-Origin")
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;


    // rodar aplicação em máquina local
   /* private List<Linguagem> linguagens =
            List.of(
                    new Linguagem(
                            "Java",
                            "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png",
                            1),
                    new Linguagem(
                            "Php",
                            "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png",
                            2)
            );*/


    //CRUD

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }

    @GetMapping("/{id}")
    public Optional<Linguagem> obterLinguagensId(@PathVariable String id) {
        Optional<Linguagem> linguagens = repositorio.findById(id);
        return linguagens;
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    }

    @PutMapping("/linguagens")
    public Linguagem alterarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repositorio.deleteById(id);
    }

}
