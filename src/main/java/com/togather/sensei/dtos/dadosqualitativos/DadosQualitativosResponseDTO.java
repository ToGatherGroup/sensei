package com.togather.sensei.dtos.dadosqualitativos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosQualitativosResponseDTO {
    List<DadosQualitativosDTO> dados;
}
