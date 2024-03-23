package com.togather.sensei.DTO.atleta;

import com.togather.sensei.DTO.campeonato.MedalhaDTO;
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
    private int idade;
    private List<MedalhaDTO> medalhaDTO;
}
