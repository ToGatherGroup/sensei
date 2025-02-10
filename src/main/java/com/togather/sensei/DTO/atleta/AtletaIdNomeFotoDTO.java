package com.togather.sensei.DTO.atleta;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AtletaIdNomeFotoDTO {
    private Long id;
    private String nome;
    private Boolean isAtivo;
    private String foto;
}
