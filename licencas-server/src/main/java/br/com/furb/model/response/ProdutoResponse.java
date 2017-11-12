package br.com.furb.model.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import br.com.furb.model.Produto;

@XmlRootElement
@XmlSeeAlso(Produto.class)
public class ProdutoResponse extends Response<Produto> {

	public ProdutoResponse() {
	}

	public ProdutoResponse(int tipo, String mensagem, String erro, Produto produto) {
		super(tipo, mensagem, erro, produto);
	}

	public ProdutoResponse(int tipo, String mensagem, Produto produto) {
		super(tipo, mensagem, produto);
	}

}
