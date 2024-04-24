package com.togather.sensei.DTO.avaliacaopostural;

import com.togather.sensei.enums.PosicaoFotoEnum;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AvaliacaoPosturalDTO {
    private String foto;
    private PosicaoFotoEnum posicao;
}
