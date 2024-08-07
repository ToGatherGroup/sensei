package com.togather.sensei.repositories;

import com.togather.sensei.DTO.campeonato.ListaCampeonatoDTO;
import com.togather.sensei.enums.PosicaoEnum;
import com.togather.sensei.models.CampeonatosDisputadosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampeonatosRepository extends JpaRepository<CampeonatosDisputadosModel, Long> {

    @Query(nativeQuery = true, value = "SELECT posicao_podium, COUNT(*) FROM campeonatos_disputados_tb WHERE atleta_id = :idAtleta AND posicao_podium != 'PARTICIPACAO' GROUP BY posicao_podium;")
    List<Object[]> listaMedalhas(Long idAtleta);

    @Query(nativeQuery = true, value = "SELECT * FROM campeonatos_disputados_tb WHERE atleta_id = :idAtleta AND posicao_podium != 0 ORDER BY posicao_podium ASC, data ASC")
    List<CampeonatosDisputadosModel> listaCampeonatosPorAtletaId(Long idAtleta);
}


