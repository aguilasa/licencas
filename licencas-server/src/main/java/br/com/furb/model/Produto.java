package br.com.furb.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "produto")
@XmlSeeAlso(Categoria.class)
public class Produto {

	private int id;
	private Categoria categoria;
	private String nome;

	public Produto() {
	}

	public Produto(int id, Categoria categoria, String nome) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
