package com.zup.api_vacinacao.controller.dto;

//
//{
//        "usuario": 1,
//        "itens": [
//        {
//        "vacina": 1,
//        "data_vacinacao": 2
//        }
//        ]
//        }


import java.time.LocalDate;

public class ItensCarteiraDTO {
    private Integer vacina;
    private LocalDate data_vacinacao;

    public ItensCarteiraDTO() {
    }

    public ItensCarteiraDTO(Integer vacina, LocalDate data_vacinacao) {
        this.vacina = vacina;
        this.data_vacinacao = data_vacinacao;
    }

    public Integer getVacina() {
        return vacina;
    }

    public void setVacina(Integer vacina) {
        this.vacina = vacina;
    }

    public LocalDate getData_vacinacao() {
        return data_vacinacao;
    }

    public void setData_vacinacao(LocalDate data_vacinacao) {
        this.data_vacinacao = data_vacinacao;
    }
}
