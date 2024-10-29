package com.projeto.backend.service;

import com.projeto.backend.model.Professor;
import com.projeto.backend.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    // Método para registrar um novo professor
    public Professor registrarProfessor(Professor professor) {
        // Salva o professor no banco de dados
        Professor professorSalvo = professorRepository.save(professor);
        System.out.println("Professor salvo com sucesso! ID: " + professorSalvo.getId());
        return professorSalvo;
    }

    // Método para listar todos os professores
    public List<Professor> listarTodosProfessores() {
        return professorRepository.findAll();
    }

    // Método para editar um professor existente
    public Optional<Professor> editarProfessor(Long id, Professor professorAtualizado) {
        return professorRepository.findById(id).map(professor -> {
            // Atualizando os dados do professor
            professor.setNome(professorAtualizado.getNome());
            professor.setCpf(professorAtualizado.getCpf());
            professor.setRg(professorAtualizado.getRg());
            professor.setDataNascimento(professorAtualizado.getDataNascimento());
            professor.setGenero(professorAtualizado.getGenero());
            // Adicionar outros campos se necessário

            // Salva o professor atualizado no banco de dados
            return professorRepository.save(professor);
        });
    }

    // Método para excluir um professor
    public boolean excluirProfessor(Long id) {
        if (professorRepository.existsById(id)) {
            professorRepository.deleteById(id);
            System.out.println("Professor excluído com sucesso! ID: " + id);
            return true;
        }
        System.out.println("Professor com ID: " + id + " não encontrado.");
        return false;
    }
}
