package com.togather.sensei.repositories;

import com.togather.sensei.models.AvaliacaoPosturalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AvaliacaoPosturalRepository extends JpaRepository<AvaliacaoPosturalModel, Long> {

    @Query("SELECT DISTINCT ap.avaliacaoPosturalPK.data FROM AvaliacaoPosturalModel ap WHERE ap.avaliacaoPosturalPK.atletaModel.id = :atletaId")
    List<LocalDate> buscarDatasDeAvaliacoesPorAtletaId(@Param("atletaId") Long atletaId);

    @Query(nativeQuery = true, value = "SELECT * FROM avaliacaopostural_tb WHERE atleta_id = :atletaId AND data = :data")
    List<AvaliacaoPosturalModel> buscarAvaliacoesPosturaisByData(Long atletaId, LocalDate data);

}
