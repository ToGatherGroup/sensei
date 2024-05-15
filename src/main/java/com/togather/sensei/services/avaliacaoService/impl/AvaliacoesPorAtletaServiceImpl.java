package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.geral.MetricaAvaliacao;
import com.togather.sensei.DTO.geral.SeriesDTO;
import com.togather.sensei.enums.AvaliacaoEnum;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.AvaliacoesPorAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvaliacoesPorAtletaServiceImpl implements AvaliacoesPorAtletaService
{
    private final AvaliacaoRepository avaliacaoRepository;
    private final AtletaRepository atletaRepository;

    public List<MetricaAvaliacao> getMetricasAvaliacao()
    {
        List<MetricaAvaliacao> lstMetricas = new ArrayList<>();

        MetricaAvaliacao metricaTemp = new MetricaAvaliacao();
        metricaTemp.setTipoAvaliacao( AvaliacaoEnum.Core );
        metricaTemp.setDescricao("Core");
        metricaTemp.setMinino(0.);
        metricaTemp.setMaximo(8.);
        metricaTemp.setIdadeMinima(0);
        lstMetricas.add(metricaTemp);

        metricaTemp = new MetricaAvaliacao();
        metricaTemp.setTipoAvaliacao( AvaliacaoEnum.ForcaMaximna );
        metricaTemp.setDescricao("Força Máxima");
        metricaTemp.setMinino(0.);
        metricaTemp.setMaximo(150.);
        metricaTemp.setIdadeMinima(11);
        lstMetricas.add(metricaTemp);

        metricaTemp = new MetricaAvaliacao();
        metricaTemp.setTipoAvaliacao( AvaliacaoEnum.ForcaExplosiva );
        metricaTemp.setDescricao("Força Explosiva");
        metricaTemp.setMinino(0.);
        metricaTemp.setMaximo(65.);
        metricaTemp.setIdadeMinima(0);
        lstMetricas.add(metricaTemp);

        metricaTemp = new MetricaAvaliacao();
        metricaTemp.setTipoAvaliacao( AvaliacaoEnum.ForcaIsometrica );
        metricaTemp.setDescricao("Força Isométrica");
        metricaTemp.setMinino(0.);
        metricaTemp.setMaximo(5.);
        metricaTemp.setIdadeMinima(0);
        lstMetricas.add(metricaTemp);

        metricaTemp = new MetricaAvaliacao();
        metricaTemp.setTipoAvaliacao( AvaliacaoEnum.MobilidadeDoTornozelo );
        metricaTemp.setDescricao("Mobilidade do Tornozelo");
        metricaTemp.setMinino(12.);
        metricaTemp.setMaximo(0.);
        metricaTemp.setIdadeMinima(0);
        lstMetricas.add(metricaTemp);

        metricaTemp = new MetricaAvaliacao();
        metricaTemp.setTipoAvaliacao( AvaliacaoEnum.ResistenciaMuscularLocalizadaAbdominal);
        metricaTemp.setDescricao("Resistência Muscular Localizada Abdominal");
        metricaTemp.setMinino(0.);
        metricaTemp.setMaximo(60.);
        metricaTemp.setIdadeMinima(0);
        lstMetricas.add(metricaTemp);

        metricaTemp = new MetricaAvaliacao();
        metricaTemp.setTipoAvaliacao( AvaliacaoEnum.ResistenciaMuscularLocalizadaMMSS );
        metricaTemp.setDescricao("Resistência Muscular Localizada MMSS");
        metricaTemp.setMinino(0.);
        metricaTemp.setMaximo(50.);
        metricaTemp.setIdadeMinima(0);
        lstMetricas.add(metricaTemp);

        metricaTemp = new MetricaAvaliacao();
        metricaTemp.setTipoAvaliacao( AvaliacaoEnum.ResistenciaAnaerobica );
        metricaTemp.setDescricao("Resistência Anaeróbica");
        metricaTemp.setMinino(0.);
        metricaTemp.setMaximo(40.);
        metricaTemp.setIdadeMinima(0);
        lstMetricas.add(metricaTemp);

        metricaTemp = new MetricaAvaliacao();
        metricaTemp.setTipoAvaliacao( AvaliacaoEnum.ResistenciaAerobica );
        metricaTemp.setDescricao("Resistência Aeróbica");
        metricaTemp.setMinino(0.);
        metricaTemp.setMaximo(3000.);
        metricaTemp.setIdadeMinima(0);
        lstMetricas.add(metricaTemp);

        return lstMetricas;
    }

    private double getPercentual(double min, double max, double valor)
    {
        double valorMaximo = max - min;
        return (valor / valorMaximo) * 100;
    }

    private double getPercentualInvertido(double min, double max, double valor)
    {
        double valorMinimo = min - max;
        return (1 - (valor/valorMinimo)) * 100;
    }

    @Override
    public SeriesDTO getAvaliacoesPorAtleta(Long atletaId)
    {
        try
        {
            List<MetricaAvaliacao> lstMetricas = getMetricasAvaliacao();

            SeriesDTO dto = new SeriesDTO();
            List<String> labels = new ArrayList<>();
            List<Double> values = new ArrayList<>();

            Optional<AtletaModel> optionalAtletaModel =atletaRepository.findById(atletaId);
            if(optionalAtletaModel.isEmpty())
                throw new NotFoundException("Nenhum atleta encontrado com o id " + atletaId);

            AtletaModel atleta = optionalAtletaModel.get();
            AvaliacaoModel avaliacao = avaliacaoRepository.getLastAvaliacaoByAtleta(atletaId);
            if(avaliacao == null)
                throw new NotFoundException("Nenhuma avaliação encontrada para o atleta " + atletaId);

            LocalDate dataAtual = LocalDate.now();

            if (atleta.getNascimento() == null) {
                throw new NotFoundException("Data de nascimento do atleta não especificada");
            }

            Period periodoEntreAsDatas = Period.between(atleta.getNascimento(), dataAtual);
            int idadeDoAtleta = periodoEntreAsDatas.getYears();

            MetricaAvaliacao metrica = lstMetricas.get( AvaliacaoEnum.Core.ordinal() );
            labels.add(metrica.getDescricao());
            double valorTemporario = getPercentual(metrica.getMinino(), metrica.getMaximo(), avaliacao.getPrancha().toMinutes());
            values.add(valorTemporario);

            if(idadeDoAtleta > 11)
            {
                metrica = lstMetricas.get(AvaliacaoEnum.ForcaMaximna.ordinal());
                labels.add(metrica.getDescricao());
                valorTemporario = getPercentual(metrica.getMinino(), metrica.getMaximo(), avaliacao.getRmTerra());
                values.add(valorTemporario);
            }

            metrica = lstMetricas.get( AvaliacaoEnum.ForcaExplosiva.ordinal() );
            labels.add(metrica.getDescricao());
            valorTemporario = getPercentual(metrica.getMinino(), metrica.getMaximo(), avaliacao.getImpulsaoVertical());
            values.add(valorTemporario);

            metrica = lstMetricas.get( AvaliacaoEnum.ForcaIsometrica.ordinal() );
            labels.add(metrica.getDescricao());
            valorTemporario = getPercentual(metrica.getMinino(), metrica.getMaximo(), avaliacao.getForcaIsometricaMaos().toMinutes());
            values.add(valorTemporario);

            metrica = lstMetricas.get( AvaliacaoEnum.MobilidadeDoTornozelo.ordinal() );
            labels.add(metrica.getDescricao());
            valorTemporario = getPercentualInvertido(metrica.getMinino(), metrica.getMaximo(), avaliacao.getTesteDeLunge());
            values.add(valorTemporario);

            metrica = lstMetricas.get( AvaliacaoEnum.ResistenciaMuscularLocalizadaAbdominal.ordinal() );
            labels.add(metrica.getDescricao());
            valorTemporario = getPercentual(metrica.getMinino(), metrica.getMaximo(), avaliacao.getAbdominais());
            values.add(valorTemporario);

            metrica = lstMetricas.get( AvaliacaoEnum.ResistenciaMuscularLocalizadaMMSS.ordinal() );
            labels.add(metrica.getDescricao());
            valorTemporario = getPercentual(metrica.getMinino(), metrica.getMaximo(), avaliacao.getFlexoes());
            values.add(valorTemporario);

            metrica = lstMetricas.get( AvaliacaoEnum.ResistenciaAnaerobica.ordinal() );
            labels.add(metrica.getDescricao());
            valorTemporario = getPercentual(metrica.getMinino(), metrica.getMaximo(), avaliacao.getBurpees());
            values.add(valorTemporario);

            metrica = lstMetricas.get( AvaliacaoEnum.ResistenciaAerobica.ordinal() );
            labels.add(metrica.getDescricao());
            valorTemporario = getPercentual(metrica.getMinino(), metrica.getMaximo(), avaliacao.getCooper());
            values.add(valorTemporario);

            dto.labels = labels.toArray(new String[0]);
            dto.values = values.stream().mapToDouble(Double::doubleValue).toArray();

            return dto;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}