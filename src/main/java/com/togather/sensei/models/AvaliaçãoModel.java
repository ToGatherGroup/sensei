package com.togather.sensei.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avaliacao_tb")
public class AvaliaçãoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private double peso;
    private double altura;
    private Duration prancha;
    private Integer flexoes;
    private Integer abdominais;
    private Integer burpees;
    private double cooper;
    private Integer rmTerra;
    private Duration forcaIsometricaMaos;
    private Double testeDeLunge;
    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private AtletaModel atletaModel;
    @Temporal(TemporalType.DATE)
    private LocalDate data;


}
