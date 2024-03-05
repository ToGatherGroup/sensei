package com.togather.sensei.services.lesaoService;

import com.togather.sensei.models.LesaoModel;
import org.springframework.stereotype.Service;

@Service
public interface CadastraLesaoService {

    LesaoModel savehistoricoLesoes(LesaoModel lesaoModel);
}
