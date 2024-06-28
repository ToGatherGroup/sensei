package com.togather.sensei.services.atletaService;


import com.togather.sensei.DTO.atleta.AtletaCardComparativoDTO;

public interface BuscaComparativoAtletaByIdService {
    AtletaCardComparativoDTO findAtletaCardById(Long id);
}
