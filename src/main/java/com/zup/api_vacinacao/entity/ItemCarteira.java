package com.zup.api_vacinacao.entity;

import java.time.LocalDate;

public class ItemCarteira {
    private Integer id;
    private CarteiraVacinacao carteira;
    private Vacina vacina;
    private LocalDate data_vacinacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarteiraVacinacao getCarteira() {
        return carteira;
    }

    public void setCarteira(CarteiraVacinacao carteira) {
        this.carteira = carteira;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public LocalDate getData_vacinacao() {
        return data_vacinacao;
    }

    public void setData_vacinacao(LocalDate data_vacinacao) {
        this.data_vacinacao = data_vacinacao;
    }
}
