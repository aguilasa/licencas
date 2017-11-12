package br.com.furb.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemProdutoId implements java.io.Serializable {

	private int pedidoId;
	private int produtoId;

	public ItemProdutoId() {
	}

	public ItemProdutoId(int pedidoId, int produtoId) {
		this.pedidoId = pedidoId;
		this.produtoId = produtoId;
	}

	@Column(name = "Pedido_id", nullable = false)
	public int getPedidoId() {
		return this.pedidoId;
	}

	public void setPedidoId(int pedidoId) {
		this.pedidoId = pedidoId;
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
		if (!(other instanceof ItemProdutoId))
			return false;
		ItemProdutoId castOther = (ItemProdutoId) other;

		return (this.getPedidoId() == castOther.getPedidoId()) && (this.getProdutoId() == castOther.getProdutoId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPedidoId();
		result = 37 * result + this.getProdutoId();
		return result;
	}

}
