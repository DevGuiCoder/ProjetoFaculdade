package com.projeto.backend.service;


import com.projeto.backend.model.Plano;
import com.projeto.backend.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public Plano registrarPlano(int duracao, double preco) {
        Plano plano = new Plano();
        plano.setNome("Teste Plano");
        plano.setDescricao("Teste Descrição");
        plano.setDuracao(duracao);
        plano.setPreco(preco);

        Plano planoSalvo = planoRepository.save(plano);
        System.out.print("Plano salvo com sucesso! ID: " + planoSalvo.getId());

        return plano;
    }

}
