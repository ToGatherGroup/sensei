package com.togather.sensei.DTO.atleta;

import com.togather.sensei.models.classificacoes.GrupoModel;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AtletaDTO {
    private Long id;
    private String nome;
    private LocalDate nascimento;
    private Character sexo;
    private String faixa;
    private String foto;
    private String email;
    private Boolean isAtivo;
    private GrupoModel grupo;

}
