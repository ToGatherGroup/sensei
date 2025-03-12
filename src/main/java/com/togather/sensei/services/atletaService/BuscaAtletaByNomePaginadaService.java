package com.togather.sensei.services.atletaService;


import com.togather.sensei.dtos.atleta.AtletaIdNomeFotoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BuscaAtletaByNomePaginadaService {

    Page<AtletaIdNomeFotoDTO> buscaNome(String nome, Pageable pageable);

}
