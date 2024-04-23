package com.togather.sensei.models;

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
public class AvaliacaoModelId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private AtletaModel atletaModel;
    @Temporal(TemporalType.DATE)
    private LocalDate data;
}
