package com.zup.api_vacinacao;

import com.zup.api_vacinacao.model.entity.Usuario;
import com.zup.api_vacinacao.model.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
;

@SpringBootApplication
public class ApiVacinacaoApplication {

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired Usuarios usuarios){
        return args -> {
            Usuario usuario = new Usuario(null,"Muriel","magnomuriel@gmail.com","06254657503","23/12/1994");
            usuarios.save(usuario);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiVacinacaoApplication.class, args);
    }

}
