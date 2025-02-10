package com.togather.sensei.repositories;

import com.togather.sensei.models.classificacoes.GrupoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<GrupoModel, Long> {
    GrupoModel findByNome(String nome);
}
