package br.com.alura.linguagens.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Extractor {

    private final String property;

    @Autowired
    public Extractor(@Value("${password}") String property) {
        this.property = property;
        // System.out.println(property);
    }

    public String getProperty() {
        return property;
    }
}