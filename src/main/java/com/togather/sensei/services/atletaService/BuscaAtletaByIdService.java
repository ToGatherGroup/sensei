package com.togather.sensei.services.atletaService;


import com.togather.sensei.models.AtletaModel;

public interface BuscaAtletaByIdService {
    AtletaModel findAtletaById(Long id);
}
