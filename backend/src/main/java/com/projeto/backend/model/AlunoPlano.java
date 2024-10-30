package com.projeto.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="alunos_planos")
public class AlunoPlano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="alunos_id")
    private Aluno aluno;

    @OneToOne
    @JoinColumn(name="plano_id")
    private Plano plano;

    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private Boolean ativo;

    // Construtor padrão
    public AlunoPlano() {}

    // Construtor com parâmetros Aluno e Plano
    public AlunoPlano(Aluno aluno, Plano plano) {
        this.aluno = aluno;
        this.plano = plano;
        this.dataInicio = LocalDate.now(); // Define a data de início como a data atual
        this.ativo = true; // Define o status como ativo inicialmente
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
