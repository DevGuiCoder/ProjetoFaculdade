package com.projeto.backend.controllers;

import com.projeto.backend.model.Plano; // Certifique-se de que este modelo existe
import com.projeto.backend.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
@Validated
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Plano>> listarPlanos() {
        List<Plano> planos = planoService.listarPlanos();
        return ResponseEntity.ok(planos);
    }

    @PostMapping("/registrar-plano")
    public ResponseEntity<String> registrarPlano(@RequestBody Plano plano) { // Mudança para @RequestBody
        planoService.registrarPlano(plano.getNome(), plano.getDescricao(), plano.getDuracao(), plano.getPreco()); // Chama o serviço
        return ResponseEntity.ok("Plano registrado com sucesso!");
    }
}
