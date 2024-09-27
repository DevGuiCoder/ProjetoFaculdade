package com.projeto.backend.repository;
import com.projeto.backend.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
