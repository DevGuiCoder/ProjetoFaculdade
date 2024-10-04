package com.projeto.backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "planos")

public class Plano {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;
    private String descricao;
    private int duracao;
    private Double preco;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public int getDuracao(){
        return duracao;
    }

    public void setDuracao(int duracao){
        this.duracao = duracao;
    }

    public Double getPreco(){
        return preco;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }

}
