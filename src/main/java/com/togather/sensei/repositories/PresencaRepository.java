package com.togather.sensei.repositories;

import com.togather.sensei.models.PresencaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PresencaRepository extends JpaRepository<PresencaModel, Long> {
    @Query(nativeQuery = true, value = "SELECT count(data) AS totalPresenca FROM presenca_tb \n" +
            "WHERE atleta_id = :idAtleta AND data BETWEEN :inicio AND :fim")
    Long buscaPresenca(Long idAtleta, String inicio, String fim);

    @Query(nativeQuery = true, value = "SELECT count(DISTINCT data) AS totalDias FROM presenca_tb \n" +
            "WHERE data BETWEEN :inicio AND :fim")
    Long buscaTotalDias(String inicio, String fim);
}
