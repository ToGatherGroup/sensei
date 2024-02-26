package com.togather.sensei.repositories;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.HistoricoLesoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoLesoesRepository extends JpaRepository<HistoricoLesoesModel, Long> {
    List<HistoricoLesoesModel> findAllByAtletaModel(AtletaModel atletaModel);
}
