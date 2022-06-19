package com.edstecno.bookshare.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.edstecno.bookshare.entities.enums.TipoEmprestimo;
import com.edstecno.bookshare.entities.pk.ItemEmprestimoPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_item_emprestimo")
public class ItemEmprestimo implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemEmprestimoPk id = new ItemEmprestimoPk();

	private Integer quantity;
	private Integer tipoEmprestimo;

	public ItemEmprestimo() {
	}

	public ItemEmprestimo(Emprestimo emprestimo, Livro livro, Integer quantity, TipoEmprestimo tipoEmprestimo) {
		this.quantity = quantity;
		this.tipoEmprestimo = tipoEmprestimo.getCode();
		id.setEmprestimo(emprestimo);
		id.setLivro(livro);
	}

	@JsonIgnore
	public Emprestimo getEmprestimo() {
		return id.getEmprestimo();
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		id.setEmprestimo(emprestimo);
	}

	public Livro getLivro() {
		return id.getLivro();
	}

	public void setLivro(Livro livro) {
		id.setLivro(livro);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTipoEmprestimo() {
		return tipoEmprestimo;
	}

	public void setTipoEmprestimo(Integer tipoEmprestimo) {
		this.tipoEmprestimo = tipoEmprestimo;
	}

	public Instant getDataDevolucao() {
		Instant devolv = Instant.now();
		return devolv = (tipoEmprestimo == 1) ? devolv.plus(15, ChronoUnit.DAYS) : devolv.plus(5, ChronoUnit.DAYS);
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
		ItemEmprestimo other = (ItemEmprestimo) obj;
		return Objects.equals(id, other.id);
	}

}
