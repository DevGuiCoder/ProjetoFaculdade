package com.projeto.backend.service;

import com.projeto.backend.dto.AlunoPlanoDTO;
import com.projeto.backend.model.Aluno;
import com.projeto.backend.model.AlunoPlano;
import com.projeto.backend.model.Plano;
import com.projeto.backend.repository.AlunoPlanoRepository;
import com.projeto.backend.repository.AlunoRepository;
import com.projeto.backend.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoPlanoService {

    private final AlunoRepository alunoRepository;
    private final PlanoRepository planoRepository;
    private final AlunoPlanoRepository alunoPlanoRepository;
    private final EntityManager entityManager;

    @Autowired
    public AlunoPlanoService(AlunoRepository alunoRepository,
                             PlanoRepository planoRepository,
                             AlunoPlanoRepository alunoPlanoRepository,
                             EntityManager entityManager) {
        this.alunoRepository = alunoRepository;
        this.planoRepository = planoRepository;
        this.alunoPlanoRepository = alunoPlanoRepository;
        this.entityManager = entityManager;
    }


    public void associarAlunoAPlano(Long alunoId, Long planoId, Boolean ativo) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Plano plano = planoRepository.findById(planoId)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

        AlunoPlano alunoPlano = new AlunoPlano();
        alunoPlano.setAluno(aluno);
        alunoPlano.setPlano(plano);
        alunoPlano.setDataInicio(LocalDate.now());
        alunoPlano.setAtivo(ativo);

        alunoPlanoRepository.save(alunoPlano);
    }


    public List<AlunoPlanoDTO> listarPlanosAtivos() {
        String sql = "SELECT a.nome AS nome_aluno, p.nome AS nome_plano, p.preco, ap.data_inicio, ap.data_termino, ap.ativo " +
                "FROM alunos_planos ap " +
                "JOIN alunos a ON ap.alunos_id = a.id " +
                "JOIN planos p ON ap.plano_id = p.id " +
                "WHERE ap.ativo = true";

        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> resultados = query.getResultList();

        List<AlunoPlanoDTO> alunoPlanos = new ArrayList<>();
        for (Object[] resultado : resultados) {
            AlunoPlanoDTO dto = new AlunoPlanoDTO();
            dto.setNomeAluno((String) resultado[0]);
            dto.setNomePlano((String) resultado[1]);
            dto.setValorPlano((Double) resultado[2]);
            dto.setDataInicio(resultado[3].toString());
            dto.setDataTermino(resultado[4].toString());


            if (resultado[5] instanceof Boolean) {
                dto.setStatus((Boolean) resultado[5] ? "Ativo" : "Cancelado");
            } else if (resultado[5] instanceof Integer) {
                dto.setStatus(((Integer) resultado[5]) == 1 ? "Ativo" : "Cancelado");
            } else {
                dto.setStatus("Desconhecido"); // Para lidar com casos inesperados
            }

            alunoPlanos.add(dto);
        }
        return alunoPlanos;
    }
}