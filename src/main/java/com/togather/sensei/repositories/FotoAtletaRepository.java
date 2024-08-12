package com.togather.sensei.repositories;

import com.togather.sensei.models.FotoAtletaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoAtletaRepository extends JpaRepository<FotoAtletaModel, Long> {

    FotoAtletaModel save(FotoAtletaModel fotoAtletaModel);

}
