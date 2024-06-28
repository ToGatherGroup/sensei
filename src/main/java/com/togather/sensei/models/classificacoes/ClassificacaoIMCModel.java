package com.togather.sensei.models.classificacoes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classificacao_imc_tb")
public class ClassificacaoIMCModel {
    @Id
    private Long id;
    private String classificacao;
    private Double  resultadoMin;
    private Double resultadoMax;
}
