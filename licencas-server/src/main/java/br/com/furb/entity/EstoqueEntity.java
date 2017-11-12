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
@Table(name = "estoque", catalog = "trabalho")
public class EstoqueEntity implements java.io.Serializable {

	private EstoqueId id;
	private ProdutoEntity produto;
	private RepresentanteEntity representante;
	private Integer quantidade;

	public EstoqueEntity() {
	}

	public EstoqueEntity(EstoqueId id, ProdutoEntity produto, RepresentanteEntity representante) {
		this.id = id;
		this.produto = produto;
		this.representante = representante;
	}

	public EstoqueEntity(EstoqueId id, ProdutoEntity produto, RepresentanteEntity representante, Integer quantidade) {
		this.id = id;
		this.produto = produto;
		this.representante = representante;
		this.quantidade = quantidade;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "representanteId", column = @Column(name = "Representante_id", nullable = false)),
			@AttributeOverride(name = "produtoId", column = @Column(name = "Produto_id", nullable = false)) })
	public EstoqueId getId() {
		return this.id;
	}

	public void setId(EstoqueId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Produto_id", nullable = false, insertable = false, updatable = false)
	public ProdutoEntity getProduto() {
		return this.produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Representante_id", nullable = false, insertable = false, updatable = false)
	public RepresentanteEntity getRepresentante() {
		return this.representante;
	}

	public void setRepresentante(RepresentanteEntity representante) {
		this.representante = representante;
	}

	@Column(name = "quantidade")
	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
