package com.edstecno.bookshare.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edstecno.bookshare.entities.Categoria;
import com.edstecno.bookshare.services.CategoriaService;

@RestController // Anotação que indica que a classe é implementada por um con trolador rest
@RequestMapping(value = "/categorias") // endereço que responde a requisição
public class CategoriaResources {

	@Autowired
	private CategoriaService service;

	@GetMapping // Anotação que indica que o metodo responde ao tipo get do http
	public ResponseEntity<List<Categoria>> findAll() {

		List<Categoria> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {

		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
