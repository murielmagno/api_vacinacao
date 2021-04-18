package com.zup.api_vacinacao.controller.dto;


import lombok.Builder;

import java.util.List;

@Builder
public class InfoCarteiraDTO {

    private Integer codigo;
    private String email;
    private String nomeCliente;
    private List<InfoItensCarteiraDTO> itens;

    public InfoCarteiraDTO() {
    }

    public InfoCarteiraDTO(Integer codigo, String email, String nomeCliente, List<InfoItensCarteiraDTO> itens) {
        this.codigo = codigo;
        this.email = email;
        this.nomeCliente = nomeCliente;
        this.itens = itens;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<InfoItensCarteiraDTO> getItens() {
        return itens;
    }

    public void setItens(List<InfoItensCarteiraDTO> itens) {
        this.itens = itens;
    }
}
