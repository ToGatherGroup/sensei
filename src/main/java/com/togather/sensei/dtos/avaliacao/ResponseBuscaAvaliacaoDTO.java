package com.togather.sensei.dtos.avaliacao;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ResponseBuscaAvaliacaoDTO {

    private Long atletaId;
    private LocalDate data;
    private ListaExerciciosDTO exercicios;
}
