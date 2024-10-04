package com.projeto.backend.controllers;

import com.projeto.backend.model.Professor;
import com.projeto.backend.service.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081,http://localhost:8081")
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;



    @GetMapping("/registrar-professor")
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
