package com.zup.api_vacinacao.controller.repository;

import com.zup.api_vacinacao.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Usuarios extends JpaRepository<Usuario,Integer> {

    List<Usuario> findByNomeLike(String nome);

    Usuario findOneByCpf(String cpf);

    Usuario findOneByEmail(String email);

    @Query(" select u from Usuario u left join fetch u.carteiras where u.id =:id")
    Usuario findUsuarioFetchCarteira (@Param("id") Integer id);

}
