package com.togather.sensei.repositories;

import com.togather.sensei.enums.PosicaoEnum;
import com.togather.sensei.models.CampeonatosDisputadosModel;
import com.togather.sensei.models.PresencaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampeonatosRepository extends JpaRepository<CampeonatosDisputadosModel, Long> {

    @Query(nativeQuery = true, value = "SELECT posicao_podium, COUNT(*) FROM campeonatos_disputados_tb WHERE atleta_id = :idAtleta GROUP BY posicao_podium;")
    List<?> listaMedalhas(Long idAtleta);


}
