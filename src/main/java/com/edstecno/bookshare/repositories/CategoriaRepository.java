package com.edstecno.bookshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edstecno.bookshare.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}