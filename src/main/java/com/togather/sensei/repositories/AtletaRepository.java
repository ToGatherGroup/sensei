package com.togather.sensei.repositories;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoPosturalModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AtletaRepository extends JpaRepository<AtletaModel, Long> {
    AtletaModel findByNome(String nome);

    @Query( value = "SELECT * from atleta_tb where nome like  %:nome% ", nativeQuery = true)
    Page<AtletaModel> buscaPorNome(String nome, Pageable pageable);

    String queryAtletasAusentesPorData =
            "  SELECT * "
           +"    FROM atleta_tb a "
           +"   WHERE a.id NOT IN (SELECT atleta_id FROM presenca_tb WHERE data = :data) "
           +"ORDER BY a.nome ";
    @Query(nativeQuery = true, value = queryAtletasAusentesPorData)
    List<AtletaModel> buscaAusentesByData(LocalDate data);

    @Query(nativeQuery = true, value = "SELECT * FROM atleta_tb WHERE isAtivo = true")
    List<AtletaModel> buscaListaAtletaIdAtivo();
}
