package com.togather.sensei.DTO.avaliacao;

import lombok.*;

import java.time.Duration;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AvaliacaoIncompletaDTO {
    private LocalDate dataAvaliacao;
    private Long idAtleta;
    private String nomeAtleta;
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
    private Double impulsaoVertical;
}
