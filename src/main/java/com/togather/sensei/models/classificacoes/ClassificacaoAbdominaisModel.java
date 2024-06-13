package com.togather.sensei.models.classificacoes;

import jakarta.persistence.*;

@Entity
@Table(name = "classificacao_abdominais_tb")

public class ClassificacaoAbdominaisModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String classificacao;
    int idadeMin;
    int idadeMax;
    int resultadoMin;
    int resultadoMax;
    Character sexo;
}
