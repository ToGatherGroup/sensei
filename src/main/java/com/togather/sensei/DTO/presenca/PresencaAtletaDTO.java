package com.togather.sensei.DTO.presenca;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PresencaAtletaDTO {
    private Long id_atleta;
    private String nome;
    private String porcentagemPresenca;
    private Long totalPresenca;
    private Long totalAusencia;
}
