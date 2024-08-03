package com.togather.sensei.repositories;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AtletaRepository extends JpaRepository<AtletaModel, Long> {
    String queryAtletasPorNome =
            "SELECT * FROM atleta_tb \n" +
                    "WHERE nome LIKE %:nome%";
    @Query(nativeQuery = true, value = queryAtletasPorNome)
    Page<AtletaModel> buscaPorNome(String nome, Pageable pageable);

    String queryAtletasAusentesPorData =
            """
                    SELECT * FROM atleta_tb a\s
                    WHERE a.id NOT IN (SELECT atleta_id FROM presenca_tb WHERE data = :data)
                    AND a.is_ativo = true
                    ORDER BY a.nome""";
    @Query(nativeQuery = true, value = queryAtletasAusentesPorData)
    List<AtletaModel> buscaAusentesByData(LocalDate data);

    String queryAtletasAtivos = "SELECT * FROM atleta_tb WHERE is_ativo = true";
    @Query(nativeQuery = true, value = queryAtletasAtivos)
    List<AtletaModel> buscaListaAtletaIdAtivo();

    @Query(nativeQuery = true, value = "SELECT sexo, nascimento FROM atleta_tb WHERE id = :atletaId")
    List<Object[]> buscaSexoNascimentoPorAtleta(@Param("atletaId") Long atletaId);
}
