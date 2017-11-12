package br.com.furb.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EstoqueId implements java.io.Serializable {

	private int representanteId;
	private int produtoId;

	public EstoqueId() {
	}

	public EstoqueId(int representanteId, int produtoId) {
		this.representanteId = representanteId;
		this.produtoId = produtoId;
	}

	@Column(name = "Representante_id", nullable = false)
	public int getRepresentanteId() {
		return this.representanteId;
	}

	public void setRepresentanteId(int representanteId) {
		this.representanteId = representanteId;
	}

	@Column(name = "Produto_id", nullable = false)
	public int getProdutoId() {
		return this.produtoId;
	}

	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EstoqueId))
			return false;
		EstoqueId castOther = (EstoqueId) other;

		return (this.getRepresentanteId() == castOther.getRepresentanteId())
				&& (this.getProdutoId() == castOther.getProdutoId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getRepresentanteId();
		result = 37 * result + this.getProdutoId();
		return result;
	}

}
