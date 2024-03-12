package com.togather.sensei.controllers.lesaoController;

import com.togather.sensei.models.LesaoModel;
import com.togather.sensei.services.lesaoService.CadastraLesaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/lesao")
public class CadastraLesaoController {

    private final CadastraLesaoService cadastraLesaoService;

    @PostMapping
    public LesaoModel cadastraLesao(@RequestBody LesaoModel lesaoModel){
     cadastraLesaoService.savehistoricoLesoes(lesaoModel);
        return lesaoModel;
    }
}
