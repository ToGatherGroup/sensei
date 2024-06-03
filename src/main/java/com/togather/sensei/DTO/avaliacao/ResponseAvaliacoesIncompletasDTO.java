package com.togather.sensei.DTO.avaliacao;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ResponseAvaliacoesIncompletasDTO {

    @Temporal(TemporalType.DATE)
    private LocalDate data;
    private List<AvaliacaoDTO> avaliacoesIncompletas;

}
