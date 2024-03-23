package com.togather.sensei.DTO.atleta;

import com.togather.sensei.models.AtletaModel;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AtletaIdNomeDTO {
    private Long id;
    private String nome;

    public AtletaIdNomeDTO(AtletaModel atletaModel) {
        id = atletaModel.getId();
        nome = atletaModel.getNome();
    }
}
