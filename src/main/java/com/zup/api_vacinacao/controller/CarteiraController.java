package com.zup.api_vacinacao.controller;

import com.zup.api_vacinacao.controller.dto.CarteiraDTO;
import com.zup.api_vacinacao.controller.dto.InfoCarteiraDTO;
import com.zup.api_vacinacao.controller.dto.InfoItensCarteiraDTO;
import com.zup.api_vacinacao.exception.RegraVacinacaoException;
import com.zup.api_vacinacao.model.entity.CarteiraVacinacao;
import com.zup.api_vacinacao.model.entity.ItemCarteira;
import com.zup.api_vacinacao.service.CarteiraService;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vacinacao")
public class CarteiraController {

    private CarteiraService service;

    public CarteiraController(CarteiraService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody CarteiraDTO dto) {
        CarteiraVacinacao carteira = service.salvar(dto);
        return carteira.getId();
    }

    @GetMapping("{id}")
    public InfoCarteiraDTO infoCarteiraById(@PathVariable Integer id) {
        return service.consultarCarteira(id).map(carteiraVacinacao -> transformar(carteiraVacinacao))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carteira não encontrada."));
    }

    private InfoCarteiraDTO transformar(CarteiraVacinacao carteiraVacinacao) {
        return InfoCarteiraDTO.builder().codigo(carteiraVacinacao.getId())
                .nomeCliente(carteiraVacinacao.getUsuario().getNome())
                .email(carteiraVacinacao.getUsuario().getEmail())
                .itens(transformarItens(carteiraVacinacao.getItens()))
                .build();

    }

    private List<InfoItensCarteiraDTO> transformarItens(List<ItemCarteira> itens) {
        if (CollectionUtils.isEmpty(itens)) {
            return Collections.EMPTY_LIST;
        }
        return itens.stream().map(itemCarteira ->
                InfoItensCarteiraDTO.builder().descricaoVacina(itemCarteira.getVacina().getNome_vacina())
                        .data_vacinacao(itemCarteira.getData_vacinacao()).build())
                .collect(Collectors.toList());

    }
}
