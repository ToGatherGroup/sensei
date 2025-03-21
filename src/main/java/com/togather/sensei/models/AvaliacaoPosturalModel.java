package com.togather.sensei.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
