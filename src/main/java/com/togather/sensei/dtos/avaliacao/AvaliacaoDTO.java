package com.togather.sensei.dtos.avaliacao;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AvaliacaoDTO {

    private Long atletaId;
    private String atletaNome;
    private ListaExerciciosDTO exercicios;
}
