package com.zup.api_vacinacao.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String cpf;

    private String data_nascimento;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<CarteiraVacinacao> carteiras;

    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
    }


    public Usuario(Integer id, String nome, String email, String cpf, String data_nascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Set<CarteiraVacinacao> getCarteiras() {
        return carteiras;
    }

    public void setCarteiras(Set<CarteiraVacinacao> carteiras) {
        this.carteiras = carteiras;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf=" + cpf +
                ", data_nascimento='" + data_nascimento + '\'' +
                '}';
    }
}
