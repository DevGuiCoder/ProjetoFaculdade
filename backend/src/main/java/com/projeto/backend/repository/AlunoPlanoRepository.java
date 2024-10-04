package com.projeto.backend.repository;
import com.projeto.backend.model.AlunoPlano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoPlanoRepository extends JpaRepository<AlunoPlano, Long> {
}