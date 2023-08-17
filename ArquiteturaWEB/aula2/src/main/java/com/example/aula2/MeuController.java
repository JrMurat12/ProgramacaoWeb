package com.example.aula2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MeuController {
    
    @Autowired
    @Qualifier("nomeAplicacao")
    private String nome;

    @Autowired
    @Qualifier("versaoAplicacao")
    private String versao;

    @GetMapping(value="obternomeAplicacao")
    public String obterNomeAplicacao() {
        return nome;
    }

    @GetMapping(value="obterversaoAplicacao")
    public String obterVersaoAplicacao() {
        return versao;
    }
    
    
}
