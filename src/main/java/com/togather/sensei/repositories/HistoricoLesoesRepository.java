package com.togather.sensei.repositories;

import com.togather.sensei.models.HistoricoLesoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoLesoesRepository extends JpaRepository<HistoricoLesoesModel, Long> {
}
