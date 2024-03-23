package com.togather.sensei.DTO;

import com.togather.sensei.enums.PosicaoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedalhaDTO {

    private String posicao;
    private String quantidade;

}
