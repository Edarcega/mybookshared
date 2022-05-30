package com.edstecno.bookshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edstecno.bookshare.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{

}