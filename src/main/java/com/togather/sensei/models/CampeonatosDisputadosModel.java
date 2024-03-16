package com.togather.sensei.models;

import com.togather.sensei.enums.PosicaoEnum;
import com.togather.sensei.enums.RegiaoCorpoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campeonatosDisputados_tb")
public class CampeonatosDisputadosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private PosicaoEnum posicaoPodium;

    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private AtletaModel atletaModel;

    @Temporal(TemporalType.DATE)
    private LocalDate data;
}
