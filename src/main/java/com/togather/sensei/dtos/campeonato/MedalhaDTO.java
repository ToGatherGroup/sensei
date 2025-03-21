package com.togather.sensei.dtos.campeonato;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedalhaDTO {

    private String posicao;
    private int quantidade;

}
