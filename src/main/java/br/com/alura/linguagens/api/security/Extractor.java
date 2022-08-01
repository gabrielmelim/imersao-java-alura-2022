package br.com.alura.linguagens.api.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "password")
public class Extractor {

    @Value("${password}")
    public String password;

    public String getPassword() {
        return password;
    }
}
