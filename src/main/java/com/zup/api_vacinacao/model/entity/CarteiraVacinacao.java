package com.zup.api_vacinacao.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carteira_vacinacao")
public class CarteiraVacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "carteira")
    private List<ItemCarteira> itens;

    public List<ItemCarteira> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarteira> itens) {
        this.itens = itens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "CarteiraVacinacao{" +
                "id=" + id +
                ", usuario=" + usuario +
                '}';
    }
}
