package br.com.furb.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "adquire")
@XmlSeeAlso(Licenca.class)
public class Adquire {

	private Date expiraEm = null;
	private Licenca licenca = null;

	public Adquire() {

	}

	public Adquire(Date expiraEm, Licenca licenca) {
		this.expiraEm = expiraEm;
		this.licenca = licenca;
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
