package com.edstecno.bookshare.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "tb_emprestimos")
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment; // Antes da versão 8 usava-se o tipo date

	@ManyToOne
	@JoinColumn(name = "doador_id")
	private Usuario doador;

	@Autowired
	private Tomador tomador;

	public Emprestimo() {

	}

	public Emprestimo(Long id, Instant moment, Usuario usuario, Tomador tomador) {
		this.id = id;
		this.moment = moment;
		this.doador = usuario;
		this.tomador = tomador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Usuario getUsuario() {
		return doador;
	}

	public void setUsuario(Usuario usuario) {
		this.doador = usuario;
	}

	public Tomador getTomador() {
		return tomador;
	}

	public void setTomador(Tomador tomador) {
		this.tomador = tomador;
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
		Emprestimo other = (Emprestimo) obj;
		return Objects.equals(id, other.id);
	}

}
