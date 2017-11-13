package br.com.furb.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "atualiza")
public class Atualiza {

	private boolean sucesso = false;

	public Atualiza() {

	}

	public Atualiza(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

}
