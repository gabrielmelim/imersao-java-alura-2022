package br.com.alura.linguagens.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Usuario {

    @Id
    String id;

   // @Indexed(unique = true)
   private String username;
    private String password;

    public Usuario() {
    }


    public Usuario(String email, String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Usuario(String id, String email, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
