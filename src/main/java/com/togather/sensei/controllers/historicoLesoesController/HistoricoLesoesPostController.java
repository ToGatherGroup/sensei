package com.togather.sensei.controllers.historicoLesoesController;

import com.togather.sensei.models.HistoricoLesoesModel;
import com.togather.sensei.services.HistoricoLesoesPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/historicolesoes")
public class HistoricoLesoesPostController {

    private final HistoricoLesoesPostService historicoLesoesPostService;

    @PostMapping
    public HistoricoLesoesModel cadastraLesao(@RequestBody HistoricoLesoesModel historicoLesoesModel){
     historicoLesoesPostService.savehistoricoLesoes(historicoLesoesModel);
        return historicoLesoesModel;
    }
}
