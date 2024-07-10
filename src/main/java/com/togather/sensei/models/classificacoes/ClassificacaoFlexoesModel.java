package com.togather.sensei.models.classificacoes;


import jakarta.persistence.*;

@Entity
@Table(name = "classificacao_flexoes_tb")
public class ClassificacaoFlexoesModel {

    @Id
    Long id;
    String classificacao;
    int idadeMin;
    int idadeMax;
    int resultadoMin;
    int resultadoMax;
    char sexo;


}
