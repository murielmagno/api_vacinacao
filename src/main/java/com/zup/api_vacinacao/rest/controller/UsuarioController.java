package com.zup.api_vacinacao.rest.controller;

import com.zup.api_vacinacao.model.entity.Usuario;
import com.zup.api_vacinacao.model.repository.Usuarios;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cadastroUsuario")
public class UsuarioController {

    private Usuarios usuarios;

    public UsuarioController(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @GetMapping("{id}")
    public Usuario getUsuarioById(@PathVariable Integer id) {
        return usuarios.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarios.save(usuario);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        usuarios.findById(id).map(usuario -> {
            usuarios.delete(usuario);
            return usuario;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuarios.findById(id).map(us -> {
            usuario.setId(us.getId());
            usuarios.save(usuario);
            return us;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario não encontrado"));
    }

    @GetMapping
    public List<Usuario> find(Usuario usuario) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(usuario, matcher);
        return usuarios.findAll(example);
    }
}
