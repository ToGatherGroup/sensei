package com.togather.sensei.services.atletaService;

import com.togather.sensei.DTO.atleta.AtletaIdNomeFotoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface BuscaAtletaPaginadaService {
    Page<AtletaIdNomeFotoDTO> buscaAtletas(Pageable pageable);

    Page<AtletaIdNomeFotoDTO> buscaAtletasFotosCache(Pageable pageable);
}
