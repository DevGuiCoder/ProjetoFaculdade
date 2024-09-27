package com.projeto.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name= "professores")
public class Professor {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String nascimento;
    private String cpf;
    private String rg;
    private String genero;   ///// Implementar o Genero futuramente



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNascimento(){
        return nascimento;
    }

    public void setNascimento(String nascimento){
        this.nascimento = nascimento;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getRg(){
        return rg;
    }

    public void setRg(String rg){
        this.rg = rg;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

}
