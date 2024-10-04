package com.projeto.backend.controllers;

import com.projeto.backend.model.Aluno;
import com.projeto.backend.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081,http://localhost:8081")
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/registrar-aluno")
    public ResponseEntity<String> registrarAluno(@RequestBody Aluno aluno) {
        alunoService.registrarAluno(aluno);
        return ResponseEntity.ok("Aluno inserido com sucesso!");
    }

    @GetMapping("/listar-alunos")
    public ResponseEntity<List<Aluno>> listarTodosAlunos() {
        List<Aluno> alunos = alunoService.listarTodosAlunos();
        return ResponseEntity.ok(alunos);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Aluno> atualizarStatus(@PathVariable Long id, @RequestParam Boolean ativo) {
        Aluno alunoAtualizado = alunoService.atualizarStatus(id, ativo);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Aluno> editarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        Aluno alunoEditado = alunoService.editarAluno(id, alunoAtualizado);
        return ResponseEntity.ok(alunoEditado);
    }
}
