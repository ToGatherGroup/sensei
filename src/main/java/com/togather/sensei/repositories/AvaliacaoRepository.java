package com.togather.sensei.repositories;

import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.models.AvaliacaoModelId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository <AvaliacaoModel, AvaliacaoModelId> {



    @Query(nativeQuery = true, value = "SELECT * from avaliacao_tb where abdominais is null or prancha is null or altura is null or burpees is null or cooper is null or flexoes is null or forca_isometrica_maos is null or\n" +
            "  impulsao_vertical is null or peso is null or prancha is null or rm_terra is null or teste_de_lunge is null ")
    List<AvaliacaoModel> getAvaliacoesIncompletas();

    @Query(nativeQuery = true, value = "SELECT DISTINCT data from avaliacao_tb where abdominais is null or prancha is null or altura is null or burpees is null or cooper is null or flexoes is null or forca_isometrica_maos is null or\n" +
            "  impulsao_vertical is null or peso is null or prancha is null or rm_terra is null or teste_de_lunge is null ")
    LocalDate getDataAvaliacoesIncompletas();

    String queryLastAvaliacaoByAtletaId = "  SELECT *\n" +
            "    FROM avaliacao_tb \n" +
            "   WHERE atleta_id = :atletaId \n" +
            "and prancha is not null \n" +
            "and altura is not null \n" +
            "and burpees is not null \n" +
            "and cooper is not null \n" +
            "and flexoes is not null \n" +
            "and forca_isometrica_maos is not null \n" +
            "and impulsao_vertical is not null \n" +
            "and peso is not null \n" +
            "and prancha is not null \n" +
            "and rm_terra is not null \n" +
            "and teste_de_lunge is not null \n" +
            "ORDER BY data DESC\n" +
            "   LIMIT 1";
    @Query(value = queryLastAvaliacaoByAtletaId, nativeQuery = true)
    AvaliacaoModel getLastAvaliacaoByAtleta(Long atletaId);

    @Query(nativeQuery = true, value = "SELECT * FROM avaliacao_tb WHERE data = :data AND atleta_id = :atletaId")
    AvaliacaoModel buscaAvaliacaoAtletaData(@Param("data") LocalDate data, @Param("atletaId") Long atletaId);

    @Query(nativeQuery = true, value = "SELECT * FROM avaliacao_tb WHERE data = :data")
    List<AvaliacaoModel> buscaAvaliacaoMesmaData(@Param("data") LocalDate data);
}