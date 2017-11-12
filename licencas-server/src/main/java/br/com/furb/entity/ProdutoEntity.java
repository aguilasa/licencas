package br.com.furb.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto", catalog = "trabalho")
public class ProdutoEntity implements java.io.Serializable {

	private Integer id;
	private CategoriaEntity categoria;
	private String nome;

	public ProdutoEntity() {
	}

	public ProdutoEntity(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public ProdutoEntity(CategoriaEntity categoria, String nome) {
		this.categoria = categoria;
		this.nome = nome;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "Categoria_id", nullable = false)
	public CategoriaEntity getCategoria() {
		return this.categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	@Column(name = "nome", length = 100)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
