package com.projeto.backend.service;


import com.projeto.backend.model.Checkin;
import com.projeto.backend.repository.CheckinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CheckinService {

    @Autowired
    private CheckinRepository checkinRepository;

    public String adicionarCheckin(Long alunoId) {
        LocalDate dataCheckin = LocalDate.now();
        Checkin novoCheckin = new Checkin(alunoId, dataCheckin);
        checkinRepository.save(novoCheckin);


        int totalCheckins = contarCheckinsDoAluno(alunoId, dataCheckin);
        String mensagem = construirMensagemCheckin(totalCheckins);


        return mensagem; // Retorna a mensagem final
    }

    private int contarCheckinsDoAluno(Long alunoId, LocalDate dataCheckin) {
        int mes = dataCheckin.getMonthValue();
        int ano = dataCheckin.getYear();
        return checkinRepository.countCheckinsByMonth(alunoId, mes, ano);
    }

    private String construirMensagemCheckin(int totalCheckins) {
        String mensagem = "Check-in registrado com sucesso! Voce tem um total de " + totalCheckins + " check-ins este mes.";

        // Verifica se o aluno atingiu a meta e adiciona a mensagem de brinde, se houver
        String brinde = verificarMetas(totalCheckins);
        if (brinde != null && !brinde.isEmpty()) {
            mensagem += " " + brinde;
        }
        return mensagem;
    }

    private String verificarMetas(int totalCheckins) {
        switch (totalCheckins) {
            case 25:
                return "Parabens! Voce atingiu a meta de 25 check-ins! Voce ganhou um premio especial!";
            case 20:
                return "Parabens! Voce atingiu a meta de 20 check-ins! Voce ganhou um brinde!";
            case 15:
                return "Parabens! Voce atingiu a meta de 15 check-ins!";
            case 10:
                return "Parabens! Voce atingiu a meta de 10 check-ins!";
            default:
                return null; // Nenhuma meta atingida
        }
    }
}
