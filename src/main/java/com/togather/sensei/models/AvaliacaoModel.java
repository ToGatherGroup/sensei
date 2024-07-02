package com.togather.sensei.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avaliacao_tb")
public class AvaliacaoModel {
    private Double peso;
    private Double altura;
    private Duration prancha;
    private Integer flexoes;
    private Integer abdominais;
    private Integer burpees;
    private Double cooper;
    private Integer rmTerra;
    private Duration forcaIsometricaMaos;
    private Double testeDeLunge;
    private Double impulsaoVertical;

    @EmbeddedId
    private AvaliacaoModelId avaliacaoModelId;


}

