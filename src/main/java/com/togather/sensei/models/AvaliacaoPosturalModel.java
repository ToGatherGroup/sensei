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
@Table(name = "{\n" +
        "  \"peso\": 70.5,\n" +
        "  \"altura\": 1.75,\n" +
        "  \"prancha\": \"PT10S\", // Formato de duração (por exemplo, 10 segundos)\n" +
        "  \"flexoes\": 20,\n" +
        "  \"abdominais\": 30,\n" +
        "  \"burpees\": 15,\n" +
        "  \"cooper\": 2000.0,\n" +
        "  \"rmTerra\": 150,\n" +
        "  \"forcaIsometricaMaos\": \"PT20S\", // Formato de duração (por exemplo, 20 segundos)\n" +
        "  \"testeDeLunge\": 3.5,\n" +
        "  \"atletaModel\": {\n" +
        "    \"id\": 123,\n" +
        "    \"nome\": \"Exemplo Atleta\"\n" +
        "  },\n" +
        "  \"data\": \"2024-04-03\" // Formato de data (por exemplo, ano-mês-dia)\n" +
        "}")
public class AvaliacaoPosturalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private LocalDate data;
    private String foto;
    @Enumerated(EnumType.STRING)
    private PosicaoFotoEnum posicao;
    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private AtletaModel atletaModel;
}
