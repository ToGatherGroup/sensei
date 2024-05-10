package com.togather.sensei.DTO.geral;

import com.togather.sensei.enums.AvaliacaoEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MetricaAvaliacao
{
    private AvaliacaoEnum tipoAvaliacao;
    private String descricao;
    private Double minino;
    private Double maximo;
    private int idadeMinima;
}
