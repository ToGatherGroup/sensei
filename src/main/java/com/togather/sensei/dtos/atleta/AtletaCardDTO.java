package com.togather.sensei.dtos.atleta;

import com.togather.sensei.dtos.campeonato.MedalhaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtletaCardDTO {

    private String nome;
    private String foto;
    private String faixa;
    private String categoria;
    private Integer idade;
    private List<MedalhaDTO> medalhaDTO;
}
