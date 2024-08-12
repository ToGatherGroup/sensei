package com.togather.sensei.services.fotoAtletaService.impl;

import com.togather.sensei.models.FotoAtletaModel;
import com.togather.sensei.repositories.FotoAtletaRepository;
import com.togather.sensei.services.fotoAtletaService.FotosAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FotosAtletaServiceImpl implements FotosAtletaService {

    private final FotoAtletaRepository fotoAtletaRepository;

    @Override
    @CacheEvict(value = "fotos", allEntries = true)
    public FotoAtletaModel createFotoAtleta(FotoAtletaModel fotoAtleta) {
        return fotoAtletaRepository.save(fotoAtleta);
    }

    @Override
    @Cacheable(value = "fotos")
    public List<FotoAtletaModel> getAllFotosAtleta() {
        return fotoAtletaRepository.findAll();
    }

    @Override
    @Cacheable(value = "foto_by_id", key = "#id")
    public FotoAtletaModel getFotoAtleta(Long id) {
        Optional<FotoAtletaModel> optionalFotoAtletaModel = fotoAtletaRepository.findById(id);
        return optionalFotoAtletaModel.orElse(null);
    }
}
