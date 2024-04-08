package com.togather.sensei.repositories;

import com.togather.sensei.models.AvaliacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository <AvaliacaoModel, Long> {
}
