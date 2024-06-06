package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.avaliacao.AvaliacaoDTO;
import com.togather.sensei.DTO.avaliacao.ListaExerciciosDTO;
import com.togather.sensei.DTO.avaliacao.ResponseAvaliacoesIncompletasDTO;
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

@Service
@RequiredArgsConstructor

public class AvaliacaoColetivaImpl implements AvaliacaoColetivaService {
    private final AvaliacaoRepository avaliacaoRepository;

    private final AtletaRepository atletaRepository;
    private final ModelMapper mapper;
    @Override
    public ResponseAvaliacoesIncompletasDTO cadastrarAvaliacaoColetiva() {
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
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();
        List<AvaliacaoDTO> avaliacaoDTOList= new ArrayList<>();

        for (AvaliacaoModel avaliacao: avaliacoesGeradas) {
            listaExercicios = mapper.map(avaliacao, ListaExerciciosDTO.class);
            avaliacaoDTO.setExercicios(listaExercicios);
            avaliacaoDTO.setAtletaId(avaliacao.getAvaliacaoModelId().getAtletaModel().getId());
            avaliacaoDTO.setAtletaNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
            avaliacaoDTOList.add(avaliacaoDTO);

        }
             ResponseAvaliacoesIncompletasDTO response= new ResponseAvaliacoesIncompletasDTO(data,avaliacaoDTOList);
        return response;
    }
}
