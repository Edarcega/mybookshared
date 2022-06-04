package com.edstecno.bookshare.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edstecno.bookshare.entities.Categoria;
import com.edstecno.bookshare.entities.Emprestimo;
import com.edstecno.bookshare.entities.Tomador;
import com.edstecno.bookshare.entities.Usuario;
import com.edstecno.bookshare.entities.enums.EmpStatus;
import com.edstecno.bookshare.repositories.CategoriaRepository;
import com.edstecno.bookshare.repositories.EmprestimoRepository;
import com.edstecno.bookshare.repositories.TomadorRepository;
import com.edstecno.bookshare.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired // Resolve a questão de injjeção de dependência
	private UserRepository userRepository;

	@Autowired // Resolve a questão de injjeção de dependência
	private TomadorRepository tomadorRepository;

	@Autowired // Resolve a questão de injjeção de dependência
	private EmprestimoRepository empRepository;
	
	@Autowired
	private CategoriaRepository catRepository;
	

	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Edimar dos Santos", "edimar.eds@gmail.com", "41997075959", "*DaviAnaMaria123");
		userRepository.save(u1);

		Tomador t1 = new Tomador(null, "Raphael Turtle", "11 99999999", "raphael.turtle@gmail.com");
		Tomador t2 = new Tomador(null, "Leonardo Turtle", "12 9999999", "Leonardo.turtle@gmail.com");
		Tomador t3 = new Tomador(null, "Michelangelo", "13 99999999", "Michelangelo.turtle@gmail.com");

		tomadorRepository.saveAll(Arrays.asList(t1, t2, t3));

		Emprestimo emp1 = new Emprestimo(null, Instant.parse("2022-06-24T17:11:00Z"), u1, t3, EmpStatus.EM_DIA);
		Emprestimo emp2 = new Emprestimo(null, Instant.parse("2022-06-24T17:11:00Z"), u1, t1, EmpStatus.EM_ATRASO);
		Emprestimo emp3 = new Emprestimo(null, Instant.parse("2022-06-24T17:11:00Z"), u1, t1, EmpStatus.EM_DIA);

		empRepository.saveAll(Arrays.asList(emp1, emp2, emp3));
		
		Categoria cat1 = new Categoria(null, "Romance");
		Categoria cat2 = new Categoria(null, "Religioso");
		Categoria cat3 = new Categoria(null, "Fantasia");
		Categoria cat4 = new Categoria(null, "Didático");
		
		catRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
		
	}

}