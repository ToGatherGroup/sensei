package com.togather.sensei.services.atletaService.impl;


import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AtletaNewModel;
import com.togather.sensei.models.FotoAtletaModel;
import com.togather.sensei.repositories.AtletaNewRepository;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.AtletaPostService;
import com.togather.sensei.services.fotoAtletaService.FotosAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastraAtletaServiceImpl implements AtletaPostService {

    private final AtletaRepository atletaRepository;
    private final AtletaNewRepository atletaNewRepository;
    private final FotosAtletaService fotosAtletaService;
  
    @Override
    public AtletaModel saveAtleta(AtletaDTO atletaDTO) {

        AtletaModel atletaModel = new AtletaModel();
        atletaModel.setNome(atletaDTO.getNome());
        atletaModel.setNascimento(atletaDTO.getNascimento());
        atletaModel.setSexo(atletaDTO.getSexo());
        atletaModel.setFaixa(atletaDTO.getFaixa());
        atletaModel.setFoto(atletaDTO.getFoto());
        atletaModel.setEmail(atletaDTO.getEmail());

        return atletaRepository.save(atletaModel);
    }

    @Override
    public AtletaNewModel saveAtletaNew(AtletaDTO atletaDTO) {

        FotoAtletaModel fotoAtletaModel = new FotoAtletaModel();
        fotoAtletaModel.setFoto(atletaDTO.getFoto());

        FotoAtletaModel fotoSave = fotosAtletaService.createFotoAtleta(fotoAtletaModel);

        AtletaNewModel atletaModel = new AtletaNewModel();
        atletaModel.setNome(atletaDTO.getNome());
        atletaModel.setNascimento(atletaDTO.getNascimento());
        atletaModel.setSexo(atletaDTO.getSexo());
        atletaModel.setFaixa(atletaDTO.getFaixa());
        atletaModel.setFoto(fotoSave);
        atletaModel.setEmail(atletaDTO.getEmail());

        return atletaNewRepository.save(atletaModel);
    }
}
