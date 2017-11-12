package br.com.furb.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CotacaoId implements java.io.Serializable {

	private Date dataInicio;
	private Date dataFim;

	public CotacaoId() {
	}

	public CotacaoId(Date dataInicio, Date dataFim) {
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	@Column(name = "data_inicio", nullable = false, length = 10)
	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Column(name = "data_fim", nullable = false, length = 10)
	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CotacaoId))
			return false;
		CotacaoId castOther = (CotacaoId) other;

		return ((this.getDataInicio() == castOther.getDataInicio()) || (this.getDataInicio() != null
				&& castOther.getDataInicio() != null && this.getDataInicio().equals(castOther.getDataInicio())))
				&& ((this.getDataFim() == castOther.getDataFim()) || (this.getDataFim() != null
						&& castOther.getDataFim() != null && this.getDataFim().equals(castOther.getDataFim())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDataInicio() == null ? 0 : this.getDataInicio().hashCode());
		result = 37 * result + (getDataFim() == null ? 0 : this.getDataFim().hashCode());
		return result;
	}

}
