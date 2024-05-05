package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.geral.SeriesDTO;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.AvaliacoesPorAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacoesPorAtletaServiceImpl implements AvaliacoesPorAtletaService
{
    private final AvaliacaoRepository avaliacaoRepository;

    private double getPercentual(double min, double max, double valor)
    {
        double valorMaximo = max - min;
        return (valor / valorMaximo) * 100;
    }

    private double getPercentualInvertido(double min, double max, double valor)
    {
        double valorMinimo = min - max;
        return (1 - (valorMinimo/valor)) * 100;
    }

    @Override
    public SeriesDTO getAvaliacoesPorAtleta(Long atletaId)
    {
        try
        {
            SeriesDTO dto = new SeriesDTO();
            List<String> labels = new ArrayList<>();
            List<Double> values = new ArrayList<>();

            AvaliacaoModel model = avaliacaoRepository.getLastAvaliacaoByAtleta(atletaId);

            if(model == null)
                throw new RuntimeException("Nenhuma avaliação encontrada para o atleta " + atletaId);

            labels.add("Core");
            model.setAbdominais(10);
            double valorTemporario = getPercentual(0, 60, model.getAbdominais());
            values.add(valorTemporario);

            labels.add("Força Máxima");
            model.setAbdominais(20);
            valorTemporario = getPercentual(0, 60, model.getAbdominais());
            values.add(valorTemporario);

            labels.add("Força Explosiva");
            model.setAbdominais(30);
            valorTemporario = getPercentual(0, 60, model.getAbdominais());
            values.add(valorTemporario);

            labels.add("Força Isométrica");
            model.setAbdominais(40);
            valorTemporario = getPercentual(0, 60, model.getAbdominais());
            values.add(valorTemporario);

            labels.add("Mobilidade do Tornozelo");
            model.setAbdominais(50);
            valorTemporario = getPercentual(0, 60, model.getAbdominais());
            values.add(valorTemporario);

            labels.add("Resistência Muscular Localizada");
            model.setAbdominais(60);
            valorTemporario = getPercentual(0, 60, model.getAbdominais());
            values.add(valorTemporario);

            labels.add("Resistência Anaeróbica");
            model.setAbdominais(35);
            valorTemporario = getPercentual(0, 60, model.getAbdominais());
            values.add(valorTemporario);

            labels.add("Resistência Aeróbica");
            model.setAbdominais(5);
            valorTemporario = getPercentual(0, 60, model.getAbdominais());
            values.add(valorTemporario);

            dto.labels = labels.toArray(new String[0]);
            dto.values = values.stream().mapToDouble(Double::doubleValue).toArray();
        /*
            prancha: 0 a 8min
            terra:0 -0 a 150
            impulsão: 0 - 65cm
            prensão manual: 5min
            lunge:  12cm -  0cm
            abdominal: 0 - 60
            flexao- 0- 50
            burpee: 0- 40
            cooper- 0 - 3000m
        */

            return dto;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}