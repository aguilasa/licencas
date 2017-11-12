package br.com.furb.model.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import br.com.furb.model.Produto;

@XmlRootElement
@XmlSeeAlso(Produto.class)
public class ProdutoResponseList extends ResponseList<Produto> {
	public ProdutoResponseList() {
	}

	public ProdutoResponseList(int tipo, String mensagem, String erro, List<Produto> lista) {
		super(tipo, mensagem, erro, lista);
	}

	public ProdutoResponseList(int tipo, String mensagem, List<Produto> lista) {
		super(tipo, mensagem, "", lista);
	}
}
