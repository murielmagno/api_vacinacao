package com.zup.api_vacinacao.service;

import com.zup.api_vacinacao.model.entity.CarteiraVacinacao;
import com.zup.api_vacinacao.controller.dto.CarteiraDTO;

import java.util.Optional;

public interface CarteiraService {

    CarteiraVacinacao salvar(CarteiraDTO dto);

    Optional<CarteiraVacinacao> consultarCarteira(Integer id);
}
