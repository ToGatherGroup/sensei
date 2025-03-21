package com.togather.sensei.services.dadosqualitativosService;

import com.togather.sensei.dtos.dadosqualitativos.DadosQualitativosResponseDTO;
import org.springframework.stereotype.Service;



@Service
public interface BuscarDadosQualitativosService {
    DadosQualitativosResponseDTO buscaDadosQualitativos(long atleta_id);
}
