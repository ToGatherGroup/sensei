package com.togather.sensei.services.atletaService.impl;


import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.AtletaPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastraAtletaServiceImpl implements AtletaPostService {

    private final AtletaRepository atletaRepository;
  
    @Override
    public AtletaModel saveAtleta(AtletaDTO atletaDTO) {

        AtletaModel atletaModel = new AtletaModel();
        atletaModel.setNome(atletaDTO.getNome());
        atletaModel.setNascimento(atletaDTO.getNascimento());
        atletaModel.setSexo(atletaDTO.getSexo());
        atletaModel.setPeso(atletaDTO.getPeso());
        atletaModel.setAltura(atletaDTO.getAltura());
        atletaModel.setCategoria(atletaDTO.getCategoria());
        atletaModel.setFaixa(atletaDTO.getFaixa());
        atletaModel.setFoto(atletaDTO.getFoto());
        atletaModel.setEmail(atletaDTO.getEmail());

        return atletaRepository.save(atletaModel);
    }
}
