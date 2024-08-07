package com.togather.sensei.services.campeonatosService;

import com.togather.sensei.DTO.campeonato.ListaCampeonatoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuscaListaCampeonatoPorAtletaIdService {
    List<ListaCampeonatoDTO> listaCampeonatosPorAtletaId(Long atleta_id);
}
