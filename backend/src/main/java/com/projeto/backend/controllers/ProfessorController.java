package com.projeto.backend.controllers;

import com.projeto.backend.model.Professor;
import com.projeto.backend.service.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081,http://localhost:8081")
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    // Registrar um novo professor
    @PostMapping("/registrar-professor")
    public ResponseEntity<Professor> registrarProfessor(@RequestBody Professor professor) {
        Professor professorSalvo = professorService.registrarProfessor(professor);
        return ResponseEntity.ok(professorSalvo);
    }

    // Listar todos os professores
    @GetMapping("/listar-professores")
    public ResponseEntity<List<Professor>> listarTodosProfessores() {
        List<Professor> professores = professorService.listarTodosProfessores();
        return ResponseEntity.ok(professores);
    }

    // Editar um professor existente
    @PutMapping("/editar-professor/{id}")
    public ResponseEntity<Professor> editarProfessor(@PathVariable Long id, @RequestBody Professor professorAtualizado) {
        Optional<Professor> professorEditado = professorService.editarProfessor(id, professorAtualizado);
        return professorEditado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se o professor não for encontrado
    }

    // Excluir um professor
    @DeleteMapping("/excluir-professor/{id}")
    public ResponseEntity<Void> excluirProfessor(@PathVariable Long id) {
        boolean excluido = professorService.excluirProfessor(id);
        return excluido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); // Retorna 204 no sucesso ou 404 se não encontrado
    }
}
