package com.togather.sensei.repositories;

import com.togather.sensei.models.HistoricoLesoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoricoLesoesRepository extends JpaRepository<HistoricoLesoesModel, Long> {

    //UTILIZANDO QUERY NATIVE
    // @Query(nativeQuery = true, value = "SELECT * FROM historico_lesoes_tb WHERE atleta_id = :atletaId")
    // List<HistoricoLesoesModel> buscarHistoricoDeLesoesPorAtletaId(long atletaId);

    //UTILIZANDO JPQL
    @Query("SELECT historico FROM HistoricoLesoesModel historico WHERE historico.atletaModel.id = :atletaId")
    List<HistoricoLesoesModel> buscarHistoricoDeLesoesPorAtletaId(@Param("atletaId") Long atletaId);
}
