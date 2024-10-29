package com.projeto.backend.service;

import com.projeto.backend.model.Plano;
import com.projeto.backend.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public List<Plano> listarPlanos() {
        return planoRepository.findAll();
    }

    // Método para registrar um plano, garantindo que os parâmetros estão na ordem correta
    public void registrarPlano(String nome, String descricao, int duracao, double preco) {
        Plano plano = new Plano();
        plano.setNome(nome);
        plano.setDescricao(descricao);
        plano.setDuracao(duracao);
        plano.setPreco(preco);
        planoRepository.save(plano);
    }
}
