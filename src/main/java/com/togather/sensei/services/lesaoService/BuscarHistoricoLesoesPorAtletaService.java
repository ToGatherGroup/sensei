package com.togather.sensei.services.lesaoService;

import com.togather.sensei.models.LesaoModel;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BuscarHistoricoLesoesPorAtletaService {
    List<LesaoModel> buscaHistoricoLesoes(long atleta_id);
}
