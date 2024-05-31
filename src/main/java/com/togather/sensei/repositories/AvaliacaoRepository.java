package com.togather.sensei.repositories;

import com.togather.sensei.models.AvaliacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository <AvaliacaoModel, Long> {

    String queryAvaliacoesIncompletas = "SELECT av.*\n" +
            "FROM avaliacao_tb av\n" +
            "JOIN atleta_tb a ON av.atleta_id = a.id\n" +
            "WHERE (av.abdominais IS NULL\n" +
            "   OR av.prancha IS NULL\n" +
            "   OR av.altura IS NULL\n" +
            "   OR av.burpees IS NULL\n" +
            "   OR av.cooper IS NULL\n" +
            "   OR av.flexoes IS NULL\n" +
            "   OR av.forca_isometrica_maos IS NULL\n" +
            "   OR av.impulsao_vertical IS NULL\n" +
            "   OR av.peso IS NULL\n" +
            "   OR av.rm_terra IS NULL\n" +
            "   OR av.teste_de_lunge IS NULL)\n" +
            "   AND a.is_ativo = TRUE";
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