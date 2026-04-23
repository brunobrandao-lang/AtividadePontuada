package com.example.SistemaEntrega.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String bemVindo() {
        return "Seja bem-vindo ao Sistema de Entrega!";
    }

    @GetMapping("/dev")
    public String desenvolvedor() {
        return "Desenvolvedor: Bruno Machado";
    }
}
