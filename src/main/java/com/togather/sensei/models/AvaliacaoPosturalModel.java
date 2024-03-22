package com.togather.sensei.models;

import com.togather.sensei.enums.PosicaoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avaliacaopostural_tb")
public class AvaliacaoPosturalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private LocalDate data;
    private String foto;
    private PosicaoEnum posicao;
    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private AtletaModel atletaModel;
}
