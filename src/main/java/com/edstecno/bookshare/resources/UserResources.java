package com.edstecno.bookshare.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edstecno.bookshare.entities.Usuario;

@RestController // Anotação que indica que a classe é implementada por um con trolador rest
@RequestMapping(value = "/usuarios") // endereço que responde a requisição
public class UserResources {
	
	@GetMapping // Anotação que indica que o metodo responde ao tipo get do http
	public ResponseEntity<Usuario> findAll(){
		Usuario u = new Usuario(1L, "Edimar", "edimar.eds@gmail.com", "419999999", "12345678");
		return ResponseEntity.ok().body(u);
	}

}
