package com.togather.sensei.services.lesaoService;

import com.togather.sensei.dtos.lesao.LesaoDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BuscarHistoricoLesoesPorAtletaService {
    List<LesaoDTO> buscaHistoricoLesoes(long atleta_id);
}
