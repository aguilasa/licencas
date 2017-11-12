package br.com.furb.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cotacao", catalog = "trabalho")
public class CotacaoEntity implements java.io.Serializable {

	private CotacaoId id;
	private String descricao;
	private Set<ProdutoCotacaoEntity> produtocotacaos = new HashSet<ProdutoCotacaoEntity>(0);

	public CotacaoEntity() {
	}

	public CotacaoEntity(CotacaoId id) {
		this.id = id;
	}

	public CotacaoEntity(CotacaoId id, String descricao, Set<ProdutoCotacaoEntity> produtocotacaos) {
		this.id = id;
		this.descricao = descricao;
		this.produtocotacaos = produtocotacaos;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dataInicio", column = @Column(name = "data_inicio", nullable = false, length = 10)),
			@AttributeOverride(name = "dataFim", column = @Column(name = "data_fim", nullable = false, length = 10)) })
	public CotacaoId getId() {
		return this.id;
	}

	public void setId(CotacaoId id) {
		this.id = id;
	}

	@Column(name = "descricao", length = 50)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotacao")
	public Set<ProdutoCotacaoEntity> getProdutocotacaos() {
		return this.produtocotacaos;
	}

	public void setProdutocotacaos(Set<ProdutoCotacaoEntity> produtocotacaos) {
		this.produtocotacaos = produtocotacaos;
	}

}
