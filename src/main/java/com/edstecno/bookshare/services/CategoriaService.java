package com.edstecno.bookshare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edstecno.bookshare.entities.Categoria;
import com.edstecno.bookshare.repositories.CategoriaRepository;

@Service // a calsse que vai se injetada automáticamente precisa estar registada como
			// coponente do spring
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id); // Estudar o tipo Optional!
		return obj.get();
	}

}
