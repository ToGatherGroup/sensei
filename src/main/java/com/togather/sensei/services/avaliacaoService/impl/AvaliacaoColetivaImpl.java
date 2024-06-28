package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.avaliacao.AvaliacaoDTO;
import com.togather.sensei.DTO.avaliacao.ListaExerciciosDTO;
import com.togather.sensei.DTO.avaliacao.ResponseAvaliacoesIncompletasDTO;
import com.togather.sensei.exceptions.BusinessException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.models.AvaliacaoModelId;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.AvaliacaoColetivaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AvaliacaoColetivaImpl implements AvaliacaoColetivaService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AtletaRepository atletaRepository;
    private final ModelMapper mapper;

    @Override
    public ResponseAvaliacoesIncompletasDTO cadastrarAvaliacaoColetiva() {
        verificaAvaliacoesEmAndamento();
        List<AtletaModel> listaAtletaIdAtivo = atletaRepository.buscaListaAtletaIdAtivo();
        LocalDate dataAtual = LocalDate.now();

        for (AtletaModel atletaId: listaAtletaIdAtivo) {
            AvaliacaoModelId avaliacaoModelId = new AvaliacaoModelId(atletaId, dataAtual);
            AvaliacaoModel avaliacaoModel = new AvaliacaoModel();
            avaliacaoModel.setAvaliacaoModelId(avaliacaoModelId);
            avaliacaoRepository.save(avaliacaoModel);
        }

      ResponseAvaliacoesIncompletasDTO response=  gerarResponse(dataAtual);

        return response;
    }


    private ResponseAvaliacoesIncompletasDTO gerarResponse(LocalDate data){
        List<AvaliacaoModel> avaliacoesGeradas= avaliacaoRepository.buscaAvaliacaoMesmaData(data);


        ListaExerciciosDTO listaExercicios = new ListaExerciciosDTO();

        List<AvaliacaoDTO> avaliacaoDTOList= new ArrayList<>();
        ResponseAvaliacoesIncompletasDTO response= new ResponseAvaliacoesIncompletasDTO();
        response.setData(data);

        for (AvaliacaoModel avaliacao: avaliacoesGeradas) {
            listaExercicios = mapper.map(avaliacao, ListaExerciciosDTO.class);
            AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();
            avaliacaoDTO.setExercicios(listaExercicios);
            avaliacaoDTO.setAtletaId(avaliacao.getAvaliacaoModelId().getAtletaModel().getId());
            avaliacaoDTO.setAtletaNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
            avaliacaoDTOList.add(avaliacaoDTO);

            response.setAvaliacoesIncompletas(avaliacaoDTOList);

        }
        return response;
    }

    public void verificaAvaliacoesEmAndamento(){

        List<AvaliacaoModel> avaliacaoModelList = avaliacaoRepository.getAvaliacoesIncompletas();

        if(!avaliacaoModelList.isEmpty()){
            throw new BusinessException("Avaliações em andamento devem ser finalizadas antes de iniciar uma nova");
        }
    }
}
