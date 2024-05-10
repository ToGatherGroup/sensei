package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.BuscaListaDeAusentesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscaListaDeAusentesServiceImpl implements BuscaListaDeAusentesService
{
    private final AtletaRepository atletaRepository;

    @Override
    public List<AtletaIdNomeDTO> getListaDeAusentes()
    {
        List<AtletaModel> lstPresencas = atletaRepository.buscaAusentesByData(LocalDate.now());
        List<AtletaIdNomeDTO> lstOut = new ArrayList<>();

        for(AtletaModel model: lstPresencas)
        {
            lstOut.add(new AtletaIdNomeDTO(model));
        }

        return lstOut;
    }
}
