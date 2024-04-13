package com.togather.sensei.repositories;

import com.togather.sensei.models.AvaliacaoPosturalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AvaliacaoPosturalRepository extends JpaRepository<AvaliacaoPosturalModel, Long> {

    @Query("SELECT DISTINCT ap.data FROM AvaliacaoPosturalModel ap WHERE ap.atletaModel.id = :atletaId")
    List<LocalDate> buscarDatasDeAvaliacoesPorAtletaId(@Param("atletaId") Long atletaId);

    //@Query("SELECT ap.id, ap.data, ap.foto, ap.posicao, ap.atletaModel FROM AvaliacaoPosturalModel  ap WHERE ap.atletaModel.id = :atletaId AND ap.data = :data AND ap.posicao = :posicao")
    @Query(value = "SELECT * FROM avaliacaopostural_tb WHERE atleta_id = :atletaId AND data = :data", nativeQuery = true)
    List<AvaliacaoPosturalModel> buscarAvaliacoesPosturaisByData(@Param("atletaId") Long atletaId, @Param("data") LocalDate data);
}
