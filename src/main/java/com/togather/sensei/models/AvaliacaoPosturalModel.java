package com.togather.sensei.models;

import com.togather.sensei.enums.PosicaoEnum;
import com.togather.sensei.enums.PosicaoFotoEnum;
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
    @EmbeddedId
    private AvaliacaoPosturalPK avaliacaoPosturalPK;
    @Column(columnDefinition = "LONGTEXT")
    private String foto;
}
