package br.com.alura.linguagens.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class test {
    public static void main(String[] args) {

        Extractor test = new Extractor();
        System.out.println(test.getPassword());
    }
}
