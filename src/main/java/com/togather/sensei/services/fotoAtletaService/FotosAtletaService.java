package com.togather.sensei.services.fotoAtletaService;

import com.togather.sensei.models.FotoAtletaModel;

import java.util.List;

public interface FotosAtletaService {
    FotoAtletaModel createFotoAtleta(FotoAtletaModel fotoAtleta);

    List<FotoAtletaModel> getAllFotosAtleta();

    FotoAtletaModel getFotoAtleta(Long id);
}
