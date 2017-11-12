package br.com.furb.model.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseList<T> {
	private int tipo;
	private boolean vazio;
	private String mensagem;
	private String erro;
	@XmlAnyElement
	private List<T> lista;

	public ResponseList() {
	}

	public ResponseList(int tipo, String mensagem, String erro, List<T> lista) {
		super();
		this.tipo = tipo;
		this.mensagem = mensagem;
		this.erro = erro;
		this.lista = lista;
	}

	public ResponseList(int tipo, String mensagem, List<T> lista) {
		this(tipo, mensagem, "", lista);
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public boolean isVazio() {
		return vazio;
	}

	public void setVazio(boolean vazio) {
		this.vazio = vazio;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public List<T> getLista() {
		return lista;
	}

	public void setLista(List<T> lista) {
		this.lista = lista;
	}

}
