package com.togather.sensei.models.classificacoes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classificacao_cooper_tb")
public class ClassificacaoCooper {
    @Id
    private Long id;
    private String classificacao;
    private Integer idadeMin;
    private Integer idadeMax;
    private Double  resultadoMin;
    private Double resultadoMax;
    private Character sexo;
}
