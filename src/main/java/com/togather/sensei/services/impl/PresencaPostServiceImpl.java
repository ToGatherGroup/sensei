package com.togather.sensei.services.impl;

import com.togather.sensei.DTO.PresencaDTO;
import com.togather.sensei.models.PresencaModel;
import com.togather.sensei.repositories.PresencaRepository;
import com.togather.sensei.services.PresencaPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PresencaPostServiceImpl implements PresencaPostService {

    private final PresencaRepository presencaRepository;

    @Override
    public PresencaModel savePresenca(PresencaDTO presencaDTO) {
        PresencaModel presencaModel = new PresencaModel();

        return presencaRepository.save(presencaModel);
    }


}
