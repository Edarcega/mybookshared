package com.edstecno.bookshare.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.edstecno.bookshare.entities.Emprestimo;
import com.edstecno.bookshare.entities.Livro;

//
@Embeddable
public class ItemEmprestimoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "Livro_id")
	private Livro livro;

	
	@ManyToOne
	@JoinColumn(name = "Emprestimo_id")
	private Emprestimo emprestimo;

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emprestimo, livro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemEmprestimoPk other = (ItemEmprestimoPk) obj;
		return Objects.equals(emprestimo, other.emprestimo) && Objects.equals(livro, other.livro);
	}

}
