package br.com.alura.linguagens.api.services;

import br.com.alura.linguagens.api.dto.UserRegisterDTO;
import br.com.alura.linguagens.api.model.Usuario;
import br.com.alura.linguagens.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class UserService {
    private @Autowired UserRepository repository;

    private Usuario newUser;

    public ResponseEntity<Usuario> CadastrarUsuario(UserRegisterDTO user) {
        Optional<Usuario> optional = repository.findByEmail(user.getEmail());

        if (optional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já em uso");
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));

            newUser = new Usuario(
                    user.getUsername(),
                    user.getPassword(),
                    user.getEmail());

            return ResponseEntity.status(201).body(repository.save(newUser));
        }

    }
}