package com.edstecno.bookshare.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edstecno.bookshare.entities.Tomador;
import com.edstecno.bookshare.services.TomadorService;

@RestController
@RequestMapping(value = "/tomadores")
public class TomadorResources {

	@Autowired
	private TomadorService service;

	@GetMapping
	public ResponseEntity<List<Tomador>> findAll() {
		List<Tomador> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tomador> findById(@PathVariable Long id){
		Tomador obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
