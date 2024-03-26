package com.togather.sensei.DTO.atleta;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AtletaDTO {
    private String nome;
    private LocalDate nascimento;
    private Character sexo;
    private Double peso;
    private Double altura;
    private String categoria;
    private String faixa;
    private String foto;
    private String email;

}
