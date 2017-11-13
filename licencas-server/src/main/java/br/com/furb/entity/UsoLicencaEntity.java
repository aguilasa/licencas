package br.com.furb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the uso_licenca database table.
 * 
 */
@Entity
@Table(name="uso_licenca")
public class UsoLicencaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expira_em")
	private Date expiraEm;

	//bi-directional many-to-one association to LicencaEntity
	@ManyToOne
	@JoinColumn(name="id_licenca")
	private LicencaEntity licencaEntity;

	public UsoLicencaEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getExpiraEm() {
		return this.expiraEm;
	}

	public void setExpiraEm(Date expiraEm) {
		this.expiraEm = expiraEm;
	}

	public LicencaEntity getLicenca() {
		return this.licencaEntity;
	}

	public void setLicenca(LicencaEntity licencaEntity) {
		this.licencaEntity = licencaEntity;
	}

}