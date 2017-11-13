package br.com.furb.model;

import java.util.Date;

public class UsoLicenca {

	private int id;
	private Date expiraEm;
	private Licenca licenca;

	public UsoLicenca() {
	}

	public UsoLicenca(int id, Date expiraEm, Licenca categoria) {
		super();
		this.id = id;
		this.expiraEm = expiraEm;
		this.licenca = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getExpiraEm() {
		return expiraEm;
	}

	public void setExpiraEm(Date expiraEm) {
		this.expiraEm = expiraEm;
	}

	public Licenca getLicenca() {
		return licenca;
	}

	public void setLicenca(Licenca licenca) {
		this.licenca = licenca;
	}

}
