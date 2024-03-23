package com.togather.sensei.services.atletaService;

import com.togather.sensei.DTO.AtletaIdNomeFotoDTO;
import com.togather.sensei.models.AtletaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface BuscaAtletaPaginadaService {
    Page<AtletaIdNomeFotoDTO> buscaAtletas(Pageable pageable);
}
