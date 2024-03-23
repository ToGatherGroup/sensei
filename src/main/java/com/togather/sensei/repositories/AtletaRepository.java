package com.togather.sensei.repositories;

import com.togather.sensei.models.AtletaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtletaRepository extends JpaRepository<AtletaModel, Long> {
    AtletaModel findByNome(String nome);

    @Query(nativeQuery = true, value = "SELECT * from atleta_tb where nome like  %:nome% ;")
    Page<AtletaModel> buscaPorNome(String nome, Pageable pageable);
}
