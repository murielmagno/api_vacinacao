package com.zup.api_vacinacao.rest.controller;

import com.zup.api_vacinacao.model.entity.CarteiraVacinacao;
import com.zup.api_vacinacao.rest.dto.CarteiraDTO;
import com.zup.api_vacinacao.service.CarteiraService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacinacao")
public class CarteiraController {

    private CarteiraService service;

    public CarteiraController(CarteiraService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody CarteiraDTO dto){
        CarteiraVacinacao carteira = service.salvar(dto);
        return carteira.getId();

    }
}
