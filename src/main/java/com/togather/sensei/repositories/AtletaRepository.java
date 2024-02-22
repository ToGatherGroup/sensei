package com.togather.sensei.repositories;

import com.togather.sensei.models.AtletaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtletaRepository extends JpaRepository<AtletaModel, Long> {
    AtletaModel findByNome(String nome);
}
