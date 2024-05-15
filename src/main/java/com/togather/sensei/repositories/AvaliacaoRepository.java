package com.togather.sensei.repositories;

import com.togather.sensei.models.AvaliacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository <AvaliacaoModel, Long> {
    @Query(value = """
            SELECT data, abdominais, altura, burpees, cooper, flexoes, forca_isometrica_maos, peso, prancha, rm_terra, teste_de_lunge, impulsao_vertical, atleta_id
            FROM (
                SELECT\s
                    data, abdominais, altura, burpees, cooper, flexoes, forca_isometrica_maos, peso, prancha, rm_terra, teste_de_lunge, impulsao_vertical, atleta_id,
                    ROW_NUMBER() OVER (PARTITION BY atleta_id ORDER BY data DESC) AS row_num
                FROM avaliacao_tb
                WHERE\s
                    abdominais IS NULL OR
                    altura IS NULL OR
                    burpees IS NULL OR
                    cooper IS NULL OR
                    flexoes IS NULL OR
                    forca_isometrica_maos IS NULL OR
                    peso IS NULL OR
                    prancha IS NULL OR
                    rm_terra IS NULL OR
                    teste_de_lunge IS NULL OR
                    impulsao_vertical IS NULL
            ) AS sub
            WHERE row_num = 1""", nativeQuery = true)
    List<AvaliacaoModel> getAvaliacoesIncompletas();

    String queryLastAvaliacaoByAtletaId = "  SELECT *\n" +
            "    FROM avaliacao_tb \n" +
            "   WHERE atleta_id = :atletaId \n" +
            "ORDER BY data DESC\n" +
            "   LIMIT 1";
    @Query(value = queryLastAvaliacaoByAtletaId, nativeQuery = true)
    AvaliacaoModel getLastAvaliacaoByAtleta(Long atletaId);
}