package br.com.furb.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProdutoCotacaoId implements java.io.Serializable {

	private int produtoId;
	private Date cotacaoDataFim;
	private Date cotacaoDataInicio;

	public ProdutoCotacaoId() {
	}

	public ProdutoCotacaoId(int produtoId, Date cotacaoDataFim, Date cotacaoDataInicio) {
		this.produtoId = produtoId;
		this.cotacaoDataFim = cotacaoDataFim;
		this.cotacaoDataInicio = cotacaoDataInicio;
	}

	@Column(name = "Produto_id", nullable = false)
	public int getProdutoId() {
		return this.produtoId;
	}

	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}

	@Column(name = "Cotacao_data_fim", nullable = false, length = 10)
	public Date getCotacaoDataFim() {
		return this.cotacaoDataFim;
	}

	public void setCotacaoDataFim(Date cotacaoDataFim) {
		this.cotacaoDataFim = cotacaoDataFim;
	}

	@Column(name = "Cotacao_data_inicio", nullable = false, length = 10)
	public Date getCotacaoDataInicio() {
		return this.cotacaoDataInicio;
	}

	public void setCotacaoDataInicio(Date cotacaoDataInicio) {
		this.cotacaoDataInicio = cotacaoDataInicio;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProdutoCotacaoId))
			return false;
		ProdutoCotacaoId castOther = (ProdutoCotacaoId) other;

		return (this.getProdutoId() == castOther.getProdutoId())
				&& ((this.getCotacaoDataFim() == castOther.getCotacaoDataFim())
						|| (this.getCotacaoDataFim() != null && castOther.getCotacaoDataFim() != null
								&& this.getCotacaoDataFim().equals(castOther.getCotacaoDataFim())))
				&& ((this.getCotacaoDataInicio() == castOther.getCotacaoDataInicio())
						|| (this.getCotacaoDataInicio() != null && castOther.getCotacaoDataInicio() != null
								&& this.getCotacaoDataInicio().equals(castOther.getCotacaoDataInicio())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProdutoId();
		result = 37 * result + (getCotacaoDataFim() == null ? 0 : this.getCotacaoDataFim().hashCode());
		result = 37 * result + (getCotacaoDataInicio() == null ? 0 : this.getCotacaoDataInicio().hashCode());
		return result;
	}

}
