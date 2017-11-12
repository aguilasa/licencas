package br.com.furb.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtocotacao", catalog = "trabalho")
public class ProdutoCotacaoEntity implements java.io.Serializable {

	private ProdutoCotacaoId id;
	private CotacaoEntity cotacao;
	private ProdutoEntity produto;
	private Float valor;

	public ProdutoCotacaoEntity() {
	}

	public ProdutoCotacaoEntity(ProdutoCotacaoId id, CotacaoEntity cotacao, ProdutoEntity produto) {
		this.id = id;
		this.cotacao = cotacao;
		this.produto = produto;
	}

	public ProdutoCotacaoEntity(ProdutoCotacaoId id, CotacaoEntity cotacao, ProdutoEntity produto, Float valor) {
		this.id = id;
		this.cotacao = cotacao;
		this.produto = produto;
		this.valor = valor;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "produtoId", column = @Column(name = "Produto_id", nullable = false)),
			@AttributeOverride(name = "cotacaoDataFim", column = @Column(name = "Cotacao_data_fim", nullable = false, length = 10)),
			@AttributeOverride(name = "cotacaoDataInicio", column = @Column(name = "Cotacao_data_inicio", nullable = false, length = 10)) })
	public ProdutoCotacaoId getId() {
		return this.id;
	}

	public void setId(ProdutoCotacaoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "Cotacao_data_inicio", referencedColumnName = "data_inicio", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "Cotacao_data_fim", referencedColumnName = "data_fim", nullable = false, insertable = false, updatable = false) })
	public CotacaoEntity getCotacao() {
		return this.cotacao;
	}

	public void setCotacao(CotacaoEntity cotacao) {
		this.cotacao = cotacao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Produto_id", nullable = false, insertable = false, updatable = false)
	public ProdutoEntity getProduto() {
		return this.produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	@Column(name = "valor", precision = 8)
	public Float getValor() {
		return this.valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

}
