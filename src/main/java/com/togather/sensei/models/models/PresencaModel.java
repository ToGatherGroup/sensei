package com.togather.sensei.models.models;

import com.togather.sensei.models.AtletaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "presenca_tb")
public class PresencaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private AtletaModel atletaModel;

}

