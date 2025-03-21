package com.togather.sensei.dtos.atleta;

import com.togather.sensei.dtos.campeonato.MedalhaDTO;
import com.togather.sensei.dtos.geral.SeriesDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtletaCardComparativoDTO {


    private String nome;
    private Double peso;
    private Double altura;
    private Integer idade;
    private String faixa;
    private List<MedalhaDTO> medalhaDTO;
    private SeriesDTO valencia;
    private String foto;

}
