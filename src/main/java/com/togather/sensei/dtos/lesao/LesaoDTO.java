package com.togather.sensei.dtos.lesao;

import com.togather.sensei.enums.RegiaoCorpoEnum;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class LesaoDTO {


    private LocalDate data;
    private String descricao;
    private RegiaoCorpoEnum regiaoLesao;

}