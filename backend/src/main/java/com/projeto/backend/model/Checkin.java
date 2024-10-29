package com.projeto.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "checkins")
public class Checkin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aluno_id", nullable = false)
    private Long alunoId;

    @Column(name = "data_checkin", nullable = false)
    private LocalDate dataCheckin;

    // Construtor padrão
    public Checkin() {
    }

    // Construtor com parâmetros
    public Checkin(Long alunoId, LocalDate dataCheckin) {
        this.alunoId = alunoId;
        this.dataCheckin = dataCheckin;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public LocalDate getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(LocalDate dataCheckin) {
        this.dataCheckin = dataCheckin;
    }
}
