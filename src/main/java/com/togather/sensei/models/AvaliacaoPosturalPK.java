package com.togather.sensei.models;

import com.togather.sensei.enums.PosicaoFotoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AvaliacaoPosturalPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private AtletaModel atletaModel;
    @Enumerated(EnumType.STRING)
    private PosicaoFotoEnum posicao;
    @Temporal(TemporalType.DATE)
    private LocalDate data;
}
