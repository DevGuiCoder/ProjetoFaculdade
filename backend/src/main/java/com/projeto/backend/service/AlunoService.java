package com.projeto.backend.service;
import com.projeto.backend.model.Aluno;
import com.projeto.backend.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno registrarAluno(Aluno aluno) {
        aluno.setDataCadastro(LocalDateTime.now());
        Aluno alunoSalvo = alunoRepository.save(aluno);
        System.out.println("Aluno salvo com sucesso! ID: " + alunoSalvo.getId());
        return alunoSalvo;
    }

    public Aluno editarAluno(Long id, Aluno alunoAtualizado){
        Aluno alunoRegistrado = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
        alunoRegistrado.setNome(alunoAtualizado.getNome());
        alunoRegistrado.setTelefone(alunoAtualizado.getTelefone());
        alunoRegistrado.setCpf(alunoAtualizado.getCpf());
        alunoRegistrado.setRg(alunoAtualizado.getRg());
        alunoRegistrado.setNascimento(alunoAtualizado.getNascimento());


        return alunoRepository.save(alunoRegistrado);

    }

    public List<Aluno> listarTodosAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno atualizarStatus(Long id, Boolean status) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        aluno.setAtivo(status);
        return alunoRepository.save(aluno);
    }




}