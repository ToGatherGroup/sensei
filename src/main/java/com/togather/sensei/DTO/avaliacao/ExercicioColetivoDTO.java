package com.togather.sensei.DTO.avaliacao;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.models.AvaliacaoModel;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ExercicioColetivoDTO {

    private Long AtletaId;
    private ListaExerciciosDTO resultado;

}
