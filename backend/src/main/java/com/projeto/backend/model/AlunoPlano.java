package com.projeto.backend.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="alunos_planos")

public class AlunoPlano {
    @Id
    @Column
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

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Aluno getAluno(){
        return aluno;
    }

    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }

    public Plano getPlano(){
        return plano;
    }

    public void setPlano(Plano plano){
        this.plano = plano;
    }

    public LocalDate getDataInicio(){
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio){
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino(){
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino){
        this.dataTermino = dataTermino;
    }

    public Boolean getAtivo(){
        return ativo;
    }

    public void setAtivo(Boolean ativo){
        this.ativo = ativo;
    }
}
