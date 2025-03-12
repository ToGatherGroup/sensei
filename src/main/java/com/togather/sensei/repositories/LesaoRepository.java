package com.togather.sensei.repositories;

import com.togather.sensei.models.LesaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LesaoRepository extends JpaRepository<LesaoModel, Long> {

     @Query(nativeQuery = true, value = "SELECT * FROM historico_lesoes_tb WHERE atleta_id = :atletaId")
     List<LesaoModel> buscarHistoricoDeLesoesPorAtletaId(long atletaId);

}
