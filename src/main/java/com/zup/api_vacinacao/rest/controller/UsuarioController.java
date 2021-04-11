package com.zup.api_vacinacao.rest.controller;

import com.zup.api_vacinacao.model.entity.Usuario;
import com.zup.api_vacinacao.model.repository.Usuarios;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private Usuarios usuarios;

    public UsuarioController(Usuarios usuarios){
        this.usuarios = usuarios;
    }

    @GetMapping("/buscarUsuario/{id}")
    @ResponseBody
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id){
        Optional<Usuario> usuario = usuarios.findById(id);
        if(usuario.isPresent()){
            return ResponseEntity.ok(usuario.get());
        }
        return ResponseEntity.notFound().build();
    }
}
