package br.com.furb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the licenca database table.
 * 
 */
@Entity
@Table(name="licenca")
public class LicencaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nome;

	//bi-directional one-to-one association to UsoLicencaEntity
	@OneToOne(mappedBy="licenca")
	private UsoLicencaEntity usoLicenca;

	public LicencaEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UsoLicencaEntity getUsoLicenca() {
		return this.usoLicenca;
	}

	public void setUsoLicenca(UsoLicencaEntity usoLicenca) {
		this.usoLicenca = usoLicenca;
	}

}