package com.projeto.backend.model;

import java.time.LocalDate;

public class Meta {
    private int diasNecessarios;
    private String descricao;

    public Meta(int diasNecessarios, String descricao) {
        this.diasNecessarios = diasNecessarios;
        this.descricao = descricao;
    }

    public int getDiasNecessarios() {
        return diasNecessarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean verificarMeta(int totalCheckins, LocalDate dataCheckin) {
        return totalCheckins >= diasNecessarios &&
                dataCheckin.getMonth() == LocalDate.now().getMonth() &&
                dataCheckin.getYear() == LocalDate.now().getYear();
    }
}
