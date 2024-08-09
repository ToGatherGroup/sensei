package com.togather.sensei.DTO.campeonato;

import com.togather.sensei.enums.PosicaoEnum;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaCampeonatoDTO {
    private String nome;
    private PosicaoEnum posicaoPodium;
    @Temporal(TemporalType.DATE)
    private LocalDate data;
}
