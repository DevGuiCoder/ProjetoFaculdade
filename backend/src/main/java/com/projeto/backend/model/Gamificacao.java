package com.projeto.backend.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Gamificacao {
    private final List<Meta> metas;

    // Construtor
    public Gamificacao() {
        metas = inicializarMetas();
    }

    // Inicializa as metas
    private List<Meta> inicializarMetas() {
        List<Meta> metas = new ArrayList<>();
        metas.add(new Meta(10, "Meta de 10 check-ins: Ganha um brinde!"));
        metas.add(new Meta(15, "Meta de 15 check-ins: Ganha uma promoção!"));
        metas.add(new Meta(20, "Meta de 20 check-ins: Ganha uma premiação especial!"));
        return metas;
    }

    // Retorna a lista de metas
    public List<Meta> getMetas() {
        return new ArrayList<>(metas); // Retorna uma cópia da lista para evitar modificações externas
    }

    // Verifica se o total de check-ins atingiu alguma meta
    public List<String> verificarMetas(int totalCheckins, LocalDate dataCheckin) {
        List<String> recompensas = new ArrayList<>();
        for (Meta meta : metas) {
            if (meta.verificarMeta(totalCheckins, dataCheckin)) {
                recompensas.add(meta.getDescricao());
            }
        }
        return recompensas;
    }
}
