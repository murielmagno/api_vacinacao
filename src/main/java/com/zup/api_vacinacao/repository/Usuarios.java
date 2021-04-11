package com.zup.api_vacinacao.repository;

import com.zup.api_vacinacao.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository
public class Usuarios {


    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }

    @Transactional
    public Usuario atualizar(Usuario usuario){
        entityManager.merge(usuario);
        return usuario;
    }
    @Transactional
    public void deletar (Usuario usuario){
        if (!entityManager.contains(usuario)){
            usuario = entityManager.merge(usuario);
        }
        entityManager.remove(usuario);

    }
    @Transactional
    public void deletar (Integer id){
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);

    }

    @Transactional
    public List<Usuario> buscarPorEmail(String email){
       String jpql = " select u from Usuario as u where u.email like :email ";
       TypedQuery<Usuario> query = entityManager.createQuery(jpql,Usuario.class);
       query.setParameter("email","%"+email+"%");
       return query.getResultList();
    }

    @Transactional
    public List<Usuario> obterTodosUsuarios() {
        return entityManager.createQuery("from Usuario",Usuario.class).getResultList();
    }

}
