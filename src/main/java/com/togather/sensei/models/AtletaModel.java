package com.togather.sensei.models;

import com.togather.sensei.models.classificacoes.GrupoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "atleta_tb")
public class AtletaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Temporal(TemporalType.DATE)
    private LocalDate nascimento;
    private Character sexo;
    private String faixa;
    @Column(columnDefinition = "LONGTEXT")
    private String foto;
    private String email;
    private Boolean isAtivo = Boolean.TRUE;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private GrupoModel grupo;

}
