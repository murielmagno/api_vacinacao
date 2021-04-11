package com.zup.api_vacinacao.rest.dto;

import java.util.List;

public class CarteiraDTO {
    private Integer usuario;
    private List<ItensCarteiraDTO> itens;

    public CarteiraDTO() {
    }

    public CarteiraDTO(Integer usuario, List<ItensCarteiraDTO> itens) {
        this.usuario = usuario;
        this.itens = itens;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public List<ItensCarteiraDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItensCarteiraDTO> itens) {
        this.itens = itens;
    }
}
