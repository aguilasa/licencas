package br.com.furb.model;

import java.util.Date;

public class Renova {

	private Date expiraEm = null;

	public Renova() {

	}

	public Renova(Date expiraEm) {
		this.expiraEm = expiraEm;
	}

	public Date getExpiraEm() {
		return expiraEm;
	}

	public void setExpiraEm(Date expiraEm) {
		this.expiraEm = expiraEm;
	}

}
