package com.togather.sensei.services.lesaoService.impl;

import com.togather.sensei.DTO.lesao.LesaoDTO;
import com.togather.sensei.models.LesaoModel;
import com.togather.sensei.repositories.LesaoRepository;
import com.togather.sensei.services.lesaoService.BuscarHistoricoLesoesPorAtletaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarLesaoPorAtletaServiceImpl implements BuscarHistoricoLesoesPorAtletaService {

    private final LesaoRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<LesaoDTO> buscaHistoricoLesoes(long atleta_id) {
         List<LesaoModel> lesaoList = repository.buscarHistoricoDeLesoesPorAtletaId(atleta_id);
         List<LesaoDTO> lesaoDTOList = new ArrayList<>();

        for (LesaoModel lesao: lesaoList) {
            LesaoDTO responseLesaoDTO = new LesaoDTO();
             responseLesaoDTO = mapper.map(lesao, LesaoDTO.class);
             responseLesaoDTO.setAtletaId(lesao.getAtletaModel().getId());
             lesaoDTOList.add(responseLesaoDTO);

        }

        return lesaoDTOList;
    }
}
