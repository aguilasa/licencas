package br.com.furb.model.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import br.com.furb.model.Categoria;

@XmlRootElement
@XmlSeeAlso(Categoria.class)
public class CategoriaResponseList extends ResponseList<Categoria> {
	public CategoriaResponseList() {
	}

	public CategoriaResponseList(int tipo, String mensagem, String erro, List<Categoria> lista) {
		super(tipo, mensagem, erro, lista);
	}

	public CategoriaResponseList(int tipo, String mensagem, List<Categoria> lista) {
		super(tipo, mensagem, "", lista);
	}
}
