package com.togather.sensei.services;

import com.togather.sensei.DTO.PresencaDTO;
import com.togather.sensei.models.PresencaModel;

public interface PresencaPostService {
    PresencaModel savePresenca(PresencaDTO presencaDTO);
}
