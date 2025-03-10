package com.togather.sensei.controllers.lesaoController;

import com.togather.sensei.models.LesaoModel;
import com.togather.sensei.services.lesaoService.CadastraLesaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/lesao")
@Tag(name = "Lesão", description = "Endpoint para gerenciamento de lesões")
public class CadastraLesaoController {

    private final CadastraLesaoService cadastraLesaoService;

    @PostMapping
    public LesaoModel cadastraLesao(@RequestBody LesaoModel lesaoModel) {
        try {
            cadastraLesaoService.savehistoricoLesoes(lesaoModel);
            return lesaoModel;
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
