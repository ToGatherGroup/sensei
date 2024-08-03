package com.togather.sensei.DTO.avaliacao;

import lombok.*;

import java.time.Duration;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ListaExerciciosDTO {

    private Double peso;
    private Double altura;
    private Duration prancha;
    private Integer flexoes;
    private Integer abdominais;
    private Integer burpees;
    private Double cooper;
    private Integer rmTerra;
    private Duration forcaIsometricaMaos;
    private Double testeDeLungeJoelhoDireito;
    private Double testeDeLungeJoelhoEsquerdo;
    private Double impulsaoVertical;
}
