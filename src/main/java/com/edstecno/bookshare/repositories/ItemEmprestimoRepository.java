package com.edstecno.bookshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edstecno.bookshare.entities.ItemEmprestimo;

public interface ItemEmprestimoRepository extends JpaRepository<ItemEmprestimo, Long>{

}