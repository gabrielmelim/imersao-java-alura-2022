package br.com.alura.linguagens.api.repository;

import br.com.alura.linguagens.api.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<Usuario, String> {

    Optional<Usuario> findByEmail(String email);

}
