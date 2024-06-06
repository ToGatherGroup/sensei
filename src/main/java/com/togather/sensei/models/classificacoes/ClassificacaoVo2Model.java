package com.togather.sensei.models.classificacoes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "classificacao_vo2_tb")
public class ClassificacaoVo2Model {

    @Id
    private Long id;
    private String classificacao;
    private Integer idadeMin;
    private Integer idadeMax;
    private Double  resultadoMin;
    private Double resultadoMax;
    private Character sexo;
}
