package com.zup.api_vacinacao.controller.repository;

import com.zup.api_vacinacao.model.entity.CarteiraVacinacao;
import com.zup.api_vacinacao.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Carteiras extends JpaRepository<CarteiraVacinacao,Integer> {

    List<CarteiraVacinacao> findByUsuario(Usuario usuario);

    @Query(" select c from CarteiraVacinacao c left join fetch c.itens where c.id =:id ")
    Optional<CarteiraVacinacao> findByIdFetchItens(@Param("id") Integer id);
}
