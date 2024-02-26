package com.togather.sensei.DTO;


import com.togather.sensei.models.AtletaModel;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PresencaDTO {
    private LocalDate data;
    private AtletaModel atletaModel;
}
