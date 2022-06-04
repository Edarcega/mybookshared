package com.edstecno.bookshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edstecno.bookshare.entities.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}