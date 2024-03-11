package com.togather.sensei.repositories;

import com.togather.sensei.models.PresencaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresencaRepository extends JpaRepository<PresencaModel, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM presenca_tb where atleta_id = :idAtleta")
    List<PresencaModel> buscaPresencasPorAtleta(Long idAtleta);

    @Query(nativeQuery = true, value = "SELECT count( DISTINCT data) FROM presenca_tb")
    Double getTotalDeDias();

    @Query(nativeQuery = true, value = "SELECT count(atleta_id) FROM presenca_tb WHERE atleta_id = :idAtleta")
    Double getDiasDoAtleta(Long idAtleta);


}
