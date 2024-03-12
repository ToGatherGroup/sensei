package com.togather.sensei.services.lesaoService.impl;


import com.togather.sensei.models.LesaoModel;
import com.togather.sensei.repositories.LesaoRepository;
import com.togather.sensei.services.lesaoService.CadastraLesaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastraLesaoServiceImpl implements CadastraLesaoService {
    private final LesaoRepository lesaoRepository;

    @Override
    public LesaoModel savehistoricoLesoes(LesaoModel lesaoModel) {
       LesaoModel model= lesaoRepository.save(lesaoModel);
        return model;
    }
}
