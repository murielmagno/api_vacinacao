package com.zup.api_vacinacao.model.repository;

import com.zup.api_vacinacao.model.entity.CarteiraVacinacao;
import com.zup.api_vacinacao.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Carteiras extends JpaRepository<CarteiraVacinacao,Integer> {

    List<CarteiraVacinacao> findByUsuario(Usuario usuario);
}
