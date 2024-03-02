package com.togather.sensei.services.impl;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.PresencaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.PresencaRepository;
import com.togather.sensei.services.ChamadaDeAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChamadaDeAtletaServiceImpl implements ChamadaDeAtletaService {

    private final PresencaRepository presencaRepository;
    private final AtletaRepository atletaRepository;
    @Override
    public void chamadaDeAtleta(List<Long> idAtletaList) {

        for (Long id: idAtletaList){

            Optional<AtletaModel> optionalAtletaModel = atletaRepository.findById(id);

            if (optionalAtletaModel.isPresent()){
                AtletaModel atletaModel = optionalAtletaModel.get();
                PresencaModel model = new PresencaModel();
                model.setData(LocalDate.now());
                model.setAtletaModel(atletaModel);

                presencaRepository.save(model);
            }
        }
    }
}
