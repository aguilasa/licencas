package br.com.furb.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "adquire")
@XmlSeeAlso(Licenca.class)
public class Adquire {

	private boolean sucesso = false;
	private Date expiraEm = null;
	private Licenca licenca = null;

	public Adquire() {

	}

	public Adquire(Date expiraEm, Licenca licenca, boolean sucesso) {
		this.expiraEm = expiraEm;
		this.licenca = licenca;
		this.sucesso = sucesso;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
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
