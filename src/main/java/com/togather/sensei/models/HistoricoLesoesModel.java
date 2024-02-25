package com.togather.sensei.models;

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
@Table(name = "historicoLesoes_tb")
public class HistoricoLesoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private LocalDate data;
    @Column(length = 500) //TODO Validar tamanho do campo para descrição de lesões.
    private String descricao;
    private RegiaoCorpoEnum regiaoLesao;
    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private AtletaModel atletaModel;
}