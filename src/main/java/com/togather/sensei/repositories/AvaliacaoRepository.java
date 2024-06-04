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
public interface AvaliacaoRepository extends JpaRepository <AvaliacaoModel, Long> {

    String queryAvaliacoesIncompletas = """
            SELECT av.*
            FROM avaliacao_tb av
            JOIN atleta_tb a ON av.atleta_id = a.id
            WHERE (av.abdominais IS NULL
               OR av.prancha IS NULL
               OR av.altura IS NULL
               OR av.burpees IS NULL
               OR av.cooper IS NULL
               OR av.flexoes IS NULL
               OR av.forca_isometrica_maos IS NULL
               OR av.impulsao_vertical IS NULL
               OR av.peso IS NULL
               OR av.rm_terra IS NULL
               OR av.teste_de_lunge IS NULL)
               AND a.is_ativo = TRUE""";
    @Query(nativeQuery = true, value = queryAvaliacoesIncompletas)
    List<AvaliacaoModel> getAvaliacoesIncompletas();

    String queryLastAvaliacaoByAtletaId = """
              SELECT *
                FROM avaliacao_tb\s
               WHERE atleta_id = :atletaId\s
            ORDER BY data DESC
               LIMIT 1""";
    @Query(value = queryLastAvaliacaoByAtletaId, nativeQuery = true)
    AvaliacaoModel getLastAvaliacaoByAtleta(Long atletaId);
}