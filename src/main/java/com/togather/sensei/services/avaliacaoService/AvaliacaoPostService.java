package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.models.AvaliacaoModel;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public interface AvaliacaoPostService extends Serializable {
    void saveAvaliacao(AvaliacaoModel avaliacaoModel);
}
