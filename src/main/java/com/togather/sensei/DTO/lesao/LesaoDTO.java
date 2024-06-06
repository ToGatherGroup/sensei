package com.togather.sensei.DTO.lesao;

import com.togather.sensei.enums.RegiaoCorpoEnum;
import com.togather.sensei.models.AtletaModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class LesaoDTO {


    private LocalDate data;
    private String descricao;
    private RegiaoCorpoEnum regiaoLesao;

}