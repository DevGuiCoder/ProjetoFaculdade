package com.projeto.backend.repository;

import com.projeto.backend.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByAtivoTrue(); // Buscar apenas alunos ativos

    List<Aluno> findByNomeContainingIgnoreCase(String nome); // Buscar alunos pelo nome
}
