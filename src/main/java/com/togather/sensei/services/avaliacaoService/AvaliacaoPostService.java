package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.models.AvaliacaoModel;
import org.springframework.stereotype.Service;

@Service
public interface AvaliacaoPostService {

    AvaliacaoModel saveAvaliacao(AvaliacaoModel avaliacaoModel);


}
