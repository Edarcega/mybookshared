package com.edstecno.bookshare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edstecno.bookshare.entities.Livro;
import com.edstecno.bookshare.repositories.LivroRepository;

@Service // a calsse que vai se injetada automáticamente precisa estar registada como
			// coponente do spring
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Livro findById(Long id) {
		Optional<Livro> obj = repository.findById(id); // Estudar o tipo Optional!
		return obj.get();
	}

}
