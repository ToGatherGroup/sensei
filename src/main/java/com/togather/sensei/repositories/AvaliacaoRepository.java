package com.togather.sensei.repositories;

import com.togather.sensei.models.AvaliacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository <AvaliacaoModel, Long> {

    String queryAvaliacoesIncompletas = "SELECT * \n" +
            "FROM avaliacao_tb \n" +
            "WHERE abdominais IS NULL \n" +
            "   OR prancha IS NULL\n" +
            "   OR altura IS NULL\n" +
            "   OR burpees IS NULL\n" +
            "   OR cooper IS NULL\n" +
            "   OR flexoes IS NULL\n" +
            "   OR forca_isometrica_maos IS NULL\n" +
            "   OR impulsao_vertical IS NULL\n" +
            "   OR peso IS NULL\n" +
            "   OR rm_terra IS NULL\n" +
            "   OR teste_de_lunge IS NULL";
    @Query(nativeQuery = true, value = queryAvaliacoesIncompletas)
    List<AvaliacaoModel> getAvaliacoesIncompletas();

    String queryLastAvaliacaoByAtletaId = "  SELECT *\n" +
            "    FROM avaliacao_tb \n" +
            "   WHERE atleta_id = :atletaId \n" +
            "ORDER BY data DESC\n" +
            "   LIMIT 1";
    @Query(value = queryLastAvaliacaoByAtletaId, nativeQuery = true)
    AvaliacaoModel getLastAvaliacaoByAtleta(Long atletaId);
}