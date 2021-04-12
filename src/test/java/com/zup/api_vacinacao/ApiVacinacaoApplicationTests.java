package com.zup.api_vacinacao;

import com.zup.api_vacinacao.model.entity.CarteiraVacinacao;
import com.zup.api_vacinacao.model.entity.Usuario;
import com.zup.api_vacinacao.controller.repository.Carteiras;
import com.zup.api_vacinacao.controller.repository.Usuarios;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApiVacinacaoApplicationTests {

	@Test
	void contextLoads(@Autowired Usuarios usuarios,@Autowired Carteiras carteiras) {

		Usuario usuario2 = new Usuario();
		usuario2.setNome("Muriel");
		usuario2.setEmail("m41512el@gmail.com");
		usuario2.setCpf("1234123");
		usuario2.setData_nascimento("23/12/1994");
		usuarios.save(usuario2);
		List<Usuario> todosUsusarios = usuarios.findAll();
		todosUsusarios.forEach(System.out::println);
		todosUsusarios = usuarios.findAll();
		todosUsusarios.forEach(System.out::println);

		System.out.println("like");
		usuarios.findByNomeLike("Muriel").forEach(System.out::println);

		System.out.println("Cpf");
		Usuario usuario1 = usuarios.findOneByCpf("06254657503");
		System.out.println(usuario1);

		System.out.println("emial");
		Usuario usuario12 = usuarios.findOneByEmail("m41512el@gmail.com");
		System.out.println(usuario12);

		CarteiraVacinacao c = new CarteiraVacinacao();
		c.setUsuario(usuario2);

		carteiras.save(c);
		Usuario us = usuarios.findUsuarioFetchCarteira(usuario2.getId());
		System.out.println(us);
		System.out.println(us.getCarteiras());
		System.out.println("----------------------");

		carteiras.findByUsuario(usuario2).forEach(System.out::println);
		System.out.println("-------------------");


	}

}
