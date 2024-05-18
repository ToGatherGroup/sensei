package com.togather.sensei.DTO.avaliacao;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AvaliacaoIncompletaDTO {

    private String valencia;
    private List<AtletaIdNomeDTO> atletas;

}
