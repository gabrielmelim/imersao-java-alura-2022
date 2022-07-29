package br.com.alura.linguagens.api.controller;

import br.com.alura.linguagens.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class UserController {

    private @Autowired UserRepository repository;


}
