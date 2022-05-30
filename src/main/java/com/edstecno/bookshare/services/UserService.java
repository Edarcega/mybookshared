package com.edstecno.bookshare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edstecno.bookshare.entities.Usuario;
import com.edstecno.bookshare.repositories.UserRepository;

@Service // a calsse que vai se injetada automáticamente precisa estar registada como
			// coponente do spring
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id); // Estudar o tipo Optional!
		return obj.get();
	}

}
