package com.projeto.backend.controllers;

import com.projeto.backend.dto.AlunoPlanoDTO;
import com.projeto.backend.service.AlunoPlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos-planos")
public class AlunoPlanoController {

    @Autowired
    private AlunoPlanoService alunoPlanoService;


    @PostMapping("/associar")
    public ResponseEntity<String> associarAlunoAPlano(
            @RequestParam Long alunoId,
            @RequestParam Long planoId,
            @RequestParam Boolean ativo) {
        try {
            alunoPlanoService.associarAlunoAPlano(alunoId, planoId, ativo);
            return ResponseEntity.status(HttpStatus.CREATED).body("Aluno associado ao plano com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao associar aluno ao plano: " + e.getMessage());
        }
    }


    @GetMapping("/listar-planos")
    public ResponseEntity<List<AlunoPlanoDTO>> listarPlanosAtivos() {
        try {
            List<AlunoPlanoDTO> planosAtivos = alunoPlanoService.listarPlanosAtivos();
            return ResponseEntity.ok(planosAtivos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
