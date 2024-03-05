package com.togather.sensei.services.atletaService;


import com.togather.sensei.models.AtletaModel;
import org.springframework.stereotype.Service;

@Service
public interface AtletaPutService {
    AtletaModel updateAtleta(AtletaModel atletaModel);
}
