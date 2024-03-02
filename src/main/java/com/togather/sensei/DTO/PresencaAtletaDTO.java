package com.togather.sensei.DTO;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PresencaAtletaDTO {

    private Long id_atleta;

    private String nome;

    private String porcentagemPresenca;

    private List<LocalDate> datasPresenca;

}
