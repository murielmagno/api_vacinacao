package com.zup.api_vacinacao.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "item_carteira")
public class ItemCarteira {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_carteira")
    private CarteiraVacinacao carteira;

    @ManyToOne
    @JoinColumn(name = "id_vacina")
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
