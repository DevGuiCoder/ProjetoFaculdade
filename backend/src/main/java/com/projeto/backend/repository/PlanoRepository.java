package com.projeto.backend.repository;
import com.projeto.backend.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
}