package com.projeto.backend.controllers;

import com.projeto.backend.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping("/registrar-plano")
    public ResponseEntity<String> registrarPlano(@RequestParam int duracao, @RequestParam double preco){
        planoService.registrarPlano(duracao, preco);
        return ResponseEntity.ok("Plano registrado com sucesso!");
    }



}
