package com.togather.sensei.models.classificacoes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classificacao_imc_adolescente_tb")
public class ClassificacaoIMCCriancaEAdolescenteModel {
    @Id
    private Long id;
    private String classificacao;
    private Integer idade;
    private Double  resultadoMin;
    private Double resultadoMax;
    private Character sexo;
}
