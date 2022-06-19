package com.edstecno.bookshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edstecno.bookshare.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}