package com.projeto.backend.controllers;

import com.projeto.backend.model.Aluno;
import com.projeto.backend.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/registrar-aluno")
    public ResponseEntity<String> registrarAluno() {
        alunoService.registrarAluno();
        return ResponseEntity.ok("Aluno inserido com sucesso!");
    }


    @GetMapping("/listar-alunos")
    public ResponseEntity<List> listarTodosAlunos(){
        List<Aluno> alunos = alunoService.listarTodosAlunos();
        return ResponseEntity.ok(alunos);

    }
    ///Utilizar o parametro status?ativo=(False/True)

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

