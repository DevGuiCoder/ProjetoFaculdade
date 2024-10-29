package com.projeto.backend.controllers;

import com.projeto.backend.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkins")
public class CheckinController {

    @Autowired
    private CheckinService checkinService; // Serviço responsável pelos check-ins

    /**
     * Adiciona um check-in para o aluno especificado pelo ID.
     *
     * @param alunoId O ID do aluno que está fazendo o check-in.
     * @return Uma resposta HTTP com a mensagem de sucesso ou erro.
     */
    @PostMapping("/{alunoId}")
    public ResponseEntity<String> adicionarCheckin(@PathVariable Long alunoId) {
        try {
            String resultado = checkinService.adicionarCheckin(alunoId); // Captura a mensagem de brinde ou confirmação
            return ResponseEntity.status(HttpStatus.OK).body(resultado); // Retorna a mensagem resultante
        } catch (Exception e) {
            // Retorna um erro se ocorrer uma exceção
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao registrar o check-in: " + e.getMessage());
        }
    }
}
