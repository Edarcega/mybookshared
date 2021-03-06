package com.edstecno.bookshare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edstecno.bookshare.entities.Tomador;
import com.edstecno.bookshare.repositories.TomadorRepository;

@Service // a calsse que vai se injetada automáticamente precisa estar registada como
			// coponente do spring
public class TomadorService {

	@Autowired
	private TomadorRepository repository;

	public List<Tomador> findAll() {
		return repository.findAll();
	}

	public Tomador findById(Long id) {
		Optional<Tomador> obj = repository.findById(id); // Estudar o tipo Optional!
		return obj.get();
	}

}
