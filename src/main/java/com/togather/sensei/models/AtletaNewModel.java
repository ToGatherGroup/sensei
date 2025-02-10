package com.togather.sensei.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "atleta_blob_tb")
public class AtletaNewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Temporal(TemporalType.DATE)
    private LocalDate nascimento;
    private Character sexo;
    private String faixa;

    private String email;
    private Boolean isAtivo = Boolean.TRUE;

    private Double peso;
    private Double altura;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foto_id", referencedColumnName = "id")
    private FotoAtletaModel foto;
}

