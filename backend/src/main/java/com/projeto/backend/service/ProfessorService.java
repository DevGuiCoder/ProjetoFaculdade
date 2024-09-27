package com.projeto.backend.service;
import com.projeto.backend.model.Aluno;
import com.projeto.backend.model.Professor;
import com.projeto.backend.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor registrarProfessor() {
        Professor professor = new Professor();
        professor.setNome("Teste Inserção");
        professor.setCpf("12345678901");
        professor.setRg("987654321");
        professor.setNascimento("01012000");
        professor.setGenero("");


        // Salvar no banco de dados
        Professor professorSalvo = professorRepository.save(professor);
        System.out.println("Professor salvo com sucesso! ID: " + professorSalvo.getId());

        // Retornar o aluno salvo
        return professorSalvo;
    }

    public List<Professor> listarTodosProfessores(){
        return professorRepository.findAll();
    }

    public Professor editarProfessor(Long id, Aluno professorAtualizado){
        Professor professorRegistrado = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: " + id));
        professorRegistrado.setNome(professorAtualizado.getNome());
        professorRegistrado.setCpf(professorAtualizado.getCpf());
        professorRegistrado.setRg(professorAtualizado.getRg());
        professorRegistrado.setNascimento(professorAtualizado.getNascimento());


        return professorRepository.save(professorRegistrado);

    }
}