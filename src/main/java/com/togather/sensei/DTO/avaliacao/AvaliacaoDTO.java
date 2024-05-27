package com.togather.sensei.DTO.avaliacao;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AvaliacaoDTO {

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
    private Long atletaId;
    @Temporal(TemporalType.DATE)
    private LocalDate data;

}
