package com.edstecno.bookshare.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edstecno.bookshare.entities.Tomador;
import com.edstecno.bookshare.entities.Usuario;
import com.edstecno.bookshare.repositories.TomadorRepository;
import com.edstecno.bookshare.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired // Resolve a questão de injjeção de dependência
	private UserRepository userRepository;

	@Autowired // Resolve a questão de injjeção de dependência
	private TomadorRepository tomadorRepository;

	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Edimar dos Santos", "edimar.eds@gmail.com", "41997075959", "*DaviAnaMaria123");
		Usuario u2 = new Usuario(null, "Joaozinho", "joaozinho@gmail.com", "41997075959", "*DaviAnaMaria123");

		userRepository.saveAll(Arrays.asList(u1, u2));

		Tomador t1 = new Tomador(null, "Helen Santos", "Helen.esther@gmail.com", "4199999999");
		Tomador t2 = new Tomador(null, "Ivania Ramalho", "ivania@gmail.com", "4199999999");

		tomadorRepository.saveAll(Arrays.asList(t1, t2));
	}

}