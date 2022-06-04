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

import com.edstecno.bookshare.entities.enums.EmpStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_emprestimos")
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")

	private Instant moment; // Antes da versão 8 usava-se o tipo date

	private Integer empStatus;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_doador")
	private Usuario doador;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_tomador")
	private Tomador tomador;

	public Emprestimo() {

	}

	public Emprestimo(Long id, Instant moment, Usuario doador, Tomador tomador, EmpStatus empStatus) {
		this.id = id;
		this.moment = moment;
		this.doador = doador;
		this.tomador = tomador;
		setEmpStatus(empStatus);
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

	public Usuario getDoador() {
		return doador;
	}

	public void setDoador(Usuario doador) {
		this.doador = doador;
	}

	public Tomador getTomador() {
		return tomador;
	}

	public void setTomador(Tomador tomador) {
		this.tomador = tomador;
	}

	public EmpStatus getEmpStatus() {
		return EmpStatus.valueOf(empStatus);
	}

	public void setEmpStatus(EmpStatus empStatus) {
		if(empStatus != null) {
			this.empStatus = empStatus.getCode();
		}
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
