package com.togather.sensei.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AtletaIdNomeFotoDTO {
    private Long id;
    private String nome;
    private String foto;
}
