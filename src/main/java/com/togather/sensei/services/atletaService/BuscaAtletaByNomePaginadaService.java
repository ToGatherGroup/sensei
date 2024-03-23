package com.togather.sensei.services.atletaService;


import com.togather.sensei.models.AtletaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BuscaAtletaByNomePaginadaService {

    Page<AtletaModel> buscaNome(String nome, Pageable pageable);

}
