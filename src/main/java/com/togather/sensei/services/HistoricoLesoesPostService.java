package com.togather.sensei.services;

import com.togather.sensei.models.HistoricoLesoesModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HistoricoLesoesPostService {

    HistoricoLesoesModel savehistoricoLesoes(HistoricoLesoesModel historicoLesoesModel);
}
