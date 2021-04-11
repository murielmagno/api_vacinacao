package com.zup.api_vacinacao;

import com.zup.api_vacinacao.entity.Usuario;
import com.zup.api_vacinacao.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ApiVacinacaoApplication {

    @Bean
    public CommandLineRunner init(@Autowired Usuarios usuarios) {
        return args -> {
            Usuario usuario = new Usuario();
            usuario.setNome("Muriel");
            usuario.setEmail("magnomuriel@gmail.com");
            usuario.setCpf("06254657503");
            usuario.setData_nascimento("23/12/1994");
            usuarios.salvar(usuario);
            List<Usuario> todosUsusarios = usuarios.obterTodosUsuarios();
            todosUsusarios.forEach(System.out::println);


            Usuario usuario2 = new Usuario();
            usuario2.setNome("Muriel");
            usuario2.setEmail("m41512el@gmail.com");
            usuario2.setCpf("1234123");
            usuario2.setData_nascimento("23/12/1994");
            usuarios.salvar(usuario2);
            todosUsusarios = usuarios.obterTodosUsuarios();
            todosUsusarios.forEach(System.out::println);



            todosUsusarios.forEach(u -> {
                u.setNome(u.getNome() + " atualizado");
                usuarios.atualizar(u);
            });

            todosUsusarios = usuarios.obterTodosUsuarios();
            todosUsusarios.forEach(System.out::println);

            usuarios.buscarPorEmail("magno").forEach(System.out::println);

			usuarios.obterTodosUsuarios().forEach(u -> {
				usuarios.deletar(u);
			});
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiVacinacaoApplication.class, args);
    }

}
