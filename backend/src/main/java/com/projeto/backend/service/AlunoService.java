package com.projeto.backend.service;

import com.projeto.backend.model.Aluno;
import com.projeto.backend.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno obterAlunoPorId(Long id) {
        return alunoRepository.findById(id).orElse(null); // Retorna o aluno ou null se não encontrado
    }

    public Aluno registrarAluno(Aluno aluno) {
        aluno.setDataCadastro(LocalDateTime.now());
        Aluno alunoSalvo = alunoRepository.save(aluno);
        System.out.println("Aluno salvo com sucesso! ID: " + alunoSalvo.getId());
        return alunoSalvo;
    }

    public Aluno editarAluno(Long id, Aluno alunoAtualizado) {
        Aluno alunoRegistrado = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
        alunoRegistrado.setNome(alunoAtualizado.getNome());
        alunoRegistrado.setTelefone(alunoAtualizado.getTelefone());
        alunoRegistrado.setCpf(alunoAtualizado.getCpf());
        alunoRegistrado.setRg(alunoAtualizado.getRg());
        alunoRegistrado.setNascimento(alunoAtualizado.getNascimento());

        return alunoRepository.save(alunoRegistrado);
    }

    public List<Aluno> listarTodosAlunosAtivos() {
        List<Aluno> todosAlunos = alunoRepository.findAll();
        return todosAlunos.stream()
                .filter(aluno -> aluno.getAtivo() == true)
                .collect(Collectors.toList());
    }// Filtra alunos ativos


    public List<Aluno> buscarAlunosPorNome(String nome) {
        return alunoRepository.findByNomeContainingIgnoreCase(nome); // Método para buscar alunos pelo nome
    }

    public Aluno atualizarStatus(Long id, Boolean status) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        aluno.setAtivo(status);
        return alunoRepository.save(aluno);
    }

    public void excluirAluno(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setAtivo(false); // Marcar como inativo
            aluno.setDataDelete(LocalDateTime.now()); // Definir a data de exclusão
            alunoRepository.save(aluno); // Atualizar o banco de dados
        } else {
            throw new RuntimeException("Aluno não encontrado");
        }
    }
}
