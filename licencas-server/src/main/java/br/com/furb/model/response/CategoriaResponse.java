package br.com.furb.model.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import br.com.furb.model.Categoria;

@XmlRootElement
@XmlSeeAlso(Categoria.class)
public class CategoriaResponse extends Response<Categoria> {

	public CategoriaResponse() {
	}

	public CategoriaResponse(int tipo, String mensagem, String erro, Categoria categoria) {
		super(tipo, mensagem, erro, categoria);
	}

	public CategoriaResponse(int tipo, String mensagem, Categoria categoria) {
		super(tipo, mensagem, categoria);
	}

}
