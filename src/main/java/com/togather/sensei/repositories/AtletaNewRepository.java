package com.togather.sensei.repositories;

import com.togather.sensei.models.AtletaNewModel;
import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AtletaNewRepository extends JpaRepository<AtletaNewModel, Long> {
    @Query(nativeQuery = true, value = "SELECT id, nome, foto_id FROM defaultdb.atleta_blob_tb")
    Page<Tuple> getDadosAtleta(Pageable pageable);
}
