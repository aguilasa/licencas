package br.com.furb.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemproduto", catalog = "trabalho")
public class ItemProdutoEntity implements java.io.Serializable {

	private ItemProdutoId id;
	private PedidoEntity pedido;
	private ProdutoEntity produto;
	private int quantidade;
	private float preco;

	public ItemProdutoEntity() {
	}

	public ItemProdutoEntity(ItemProdutoId id, PedidoEntity pedido, ProdutoEntity produto, int quantidade, float preco) {
		this.id = id;
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "pedidoId", column = @Column(name = "Pedido_id", nullable = false)),
			@AttributeOverride(name = "produtoId", column = @Column(name = "Produto_id", nullable = false)) })
	public ItemProdutoId getId() {
		return this.id;
	}

	public void setId(ItemProdutoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Pedido_id", nullable = false, insertable = false, updatable = false)
	public PedidoEntity getPedido() {
		return this.pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Produto_id", nullable = false, insertable = false, updatable = false)
	public ProdutoEntity getProduto() {
		return this.produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	@Column(name = "quantidade", nullable = false)
	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Column(name = "preco", nullable = false, precision = 8)
	public float getPreco() {
		return this.preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

}
