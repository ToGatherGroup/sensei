package com.togather.sensei.services;

import com.togather.sensei.models.AtletaModel;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface AtletaGetService {
    List<AtletaModel> buscaAtletas();
}
