package com.togather.sensei.services.atletaService;


import com.togather.sensei.DTO.AtletaDTO;
import com.togather.sensei.DTO.AtletaIdNomeFotoDTO;
import com.togather.sensei.models.AtletaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface BuscaAtletaByNomePaginadaService {

    Page<AtletaModel> buscaNome(String nome, Pageable pageable);

}
