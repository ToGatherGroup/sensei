package com.togather.sensei.repositories;

import com.togather.sensei.models.classificacoes.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {


    @Query(nativeQuery = true, value = "select descricao from categoria_tb where :idade between idade_min and idade_max;")
    String gerarCategoria(int idade);

}
