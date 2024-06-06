package com.togather.sensei.models.classificacoes;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria_tb")


public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int idadeMin;
    int idadeMax;
    String descricao;



}
