package com.zup.api_vacinacao.controller.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class InfoItensCarteiraDTO {
    private String descricaoVacina;
    private LocalDate data_vacinacao;

    public InfoItensCarteiraDTO() {
    }

    public InfoItensCarteiraDTO(String descricaoVacina, LocalDate data_vacinacao) {
        this.descricaoVacina = descricaoVacina;
        this.data_vacinacao = data_vacinacao;
    }

    public String getDescricaoVacina() {
        return descricaoVacina;
    }

    public void setDescricaoVacina(String descricaoVacina) {
        this.descricaoVacina = descricaoVacina;
    }

    public LocalDate getData_vacinacao() {
        return data_vacinacao;
    }

    public void setData_vacinacao(LocalDate data_vacinacao) {
        this.data_vacinacao = data_vacinacao;
    }
}
