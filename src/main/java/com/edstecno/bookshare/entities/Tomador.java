package com.edstecno.bookshare.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tomador")
public class Tomador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String celular;
	private String email;

	//@JsonIgnore
	@OneToMany(mappedBy = "tomador")
	private List<Emprestimo> emprestimos = new ArrayList<>();

	public Tomador() {

	}

	public Tomador(Long id, String nome, String celular, String email) {
		this.id = id;
		this.nome = nome;
		this.celular = celular;
		this.email = email;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tomador other = (Tomador) obj;
		return Objects.equals(id, other.id);
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

}
