package com.projeto.backend.controllers;

import com.projeto.backend.model.Professor;
import com.projeto.backend.service.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081,http://localhost:8081")
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;



    @PostMapping("/registrar-professor")
    public ResponseEntity<String> registrarProfessor(){
        professorService.registrarProfessor();
        return ResponseEntity.ok("Professor inserido com sucesso!");
    }


    @GetMapping("/listar-professores")
    public ResponseEntity<List>listarTodosProfessores(){
        List<Professor> professores = professorService.listarTodosProfessores();
        return ResponseEntity.ok(professores);
    }
}
