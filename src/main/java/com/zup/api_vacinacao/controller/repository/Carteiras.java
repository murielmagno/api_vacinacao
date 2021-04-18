package com.zup.api_vacinacao.controller.repository;

import com.zup.api_vacinacao.model.entity.CarteiraVacinacao;
import com.zup.api_vacinacao.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Carteiras extends JpaRepository<CarteiraVacinacao,Integer> {

    List<CarteiraVacinacao> findByUsuario(Usuario usuario);

    Optional<CarteiraVacinacao> findByIdFechItens(Integer id);
}
