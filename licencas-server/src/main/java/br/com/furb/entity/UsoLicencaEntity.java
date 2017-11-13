package br.com.furb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the uso_licenca database table.
 * 
 */
@Entity
@Table(name="uso_licenca")
@NamedQuery(name="UsoLicencaEntity.findAll", query="SELECT u FROM UsoLicencaEntity u")
public class UsoLicencaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_licenca")
	private int idLicenca;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expira_em")
	private Date expiraEm;

	//bi-directional one-to-one association to LicencaEntity
	@OneToOne
	@JoinColumn(name="id_licenca")
	private LicencaEntity licenca;

	public UsoLicencaEntity() {
	}

	public int getIdLicenca() {
		return this.idLicenca;
	}

	public void setIdLicenca(int idLicenca) {
		this.idLicenca = idLicenca;
	}

	public Date getExpiraEm() {
		return this.expiraEm;
	}

	public void setExpiraEm(Date expiraEm) {
		this.expiraEm = expiraEm;
	}

	public LicencaEntity getLicenca() {
		return this.licenca;
	}

	public void setLicenca(LicencaEntity licenca) {
		this.licenca = licenca;
	}

}