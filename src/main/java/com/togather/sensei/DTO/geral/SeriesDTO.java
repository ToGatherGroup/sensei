package com.togather.sensei.DTO.geral;

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