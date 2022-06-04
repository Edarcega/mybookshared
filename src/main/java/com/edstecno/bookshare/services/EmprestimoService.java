package com.edstecno.bookshare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edstecno.bookshare.entities.Emprestimo;
import com.edstecno.bookshare.repositories.EmprestimoRepository;

@Service // a calsse que vai se injetada automáticamente precisa estar registada como
			// coponente do spring
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repository;

	public List<Emprestimo> findAll() {
		return repository.findAll();
	}

	
	public Emprestimo findById(Long id) {
		Optional<Emprestimo> obj = repository.findById(id); // Estudar o tipo Optional!
		return obj.get();
	}

}
