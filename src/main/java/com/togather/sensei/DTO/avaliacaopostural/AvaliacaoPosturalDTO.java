package com.togather.sensei.DTO.avaliacaopostural;

import com.togather.sensei.enums.PosicaoFotoEnum;
import com.togather.sensei.models.AvaliacaoPosturalModel;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AvaliacaoPosturalDTO {
    private Long id;
    private LocalDate data;
    private String foto;
    private PosicaoFotoEnum posicao;

    public AvaliacaoPosturalDTO(AvaliacaoPosturalModel avaliacaoPosturalModel) {
        id = avaliacaoPosturalModel.getId();
        data = avaliacaoPosturalModel.getData();
        foto = avaliacaoPosturalModel.getFoto();
        posicao = avaliacaoPosturalModel.getPosicao();
    }
}
