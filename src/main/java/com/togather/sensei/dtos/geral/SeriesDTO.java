package com.togather.sensei.dtos.geral;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SeriesDTO
{
    public String[] labels;
    public double[] values;
}