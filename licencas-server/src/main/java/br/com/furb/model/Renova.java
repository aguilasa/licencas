package br.com.furb.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "adquire")
public class Renova {

	private boolean sucesso = false;
	private Date expiraEm = null;

	public Renova() {

	}

	public Renova(boolean sucesso, Date expiraEm) {
		this.sucesso = sucesso;
		this.expiraEm = expiraEm;
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

}
