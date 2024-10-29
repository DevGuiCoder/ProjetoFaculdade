package com.projeto.backend.repository;

import com.projeto.backend.model.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CheckinRepository extends JpaRepository<Checkin, Long> {

    @Query(value = "SELECT checkins_mes(:alunoId, :mes, :ano)", nativeQuery = true)
    int countCheckinsByMonth(@Param("alunoId") Long alunoId, @Param("mes") int mes, @Param("ano") int ano);


    @Query(value = "SELECT verificar_meta_checkins(:alunoId::BIGINT, :mes::INT, :ano::INT)", nativeQuery = true)
    String verificarMetaCheckins(@Param("alunoId") Long alunoId, @Param("mes") int mes, @Param("ano") int ano);
}
