package br.com.alura.linguagens.api.repository;

import br.com.alura.linguagens.api.model.Linguagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinguagemRepository extends MongoRepository<Linguagem, String> {

}
