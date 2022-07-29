package br.com.alura.linguagens.api.dto;

import org.hibernate.validator.constraints.NotBlank;

public class UserLoginDTO {
    private @NotBlank String username;
    private @NotBlank String password;

    public UserLoginDTO(){
    }

    public UserLoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
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
