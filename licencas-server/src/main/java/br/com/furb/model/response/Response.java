package br.com.furb.model.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Response<T> {
	private int tipo;
	private String mensagem;
	private String erro;
	@XmlAnyElement
	private T objeto;
	
	public Response() {
	}

	public Response(int tipo, String mensagem, String erro, T objeto) {
		super();
		this.tipo = tipo;
		this.mensagem = mensagem;
		this.erro = erro;
		this.objeto = objeto;
	}
	
	public Response(int tipo, String mensagem, T objeto) {
		this(tipo, mensagem, "", objeto);
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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

	public T getObjeto() {
		return objeto;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

}
