package br.com.furb.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funcao", catalog = "trabalho")
public class FuncaoEntity implements java.io.Serializable {

	private Integer id;
	private String nome;
	private String admin;
	private Set<UsuarioEntity> usuarios = new HashSet<UsuarioEntity>(0);
	private Set<UsuarioEntity> usuarios_1 = new HashSet<UsuarioEntity>(0);

	public FuncaoEntity() {
	}

	public FuncaoEntity(String nome, String admin) {
		this.nome = nome;
		this.admin = admin;
	}

	public FuncaoEntity(String nome, String admin, Set<UsuarioEntity> usuarios, Set<UsuarioEntity> usuarios_1) {
		this.nome = nome;
		this.admin = admin;
		this.usuarios = usuarios;
		this.usuarios_1 = usuarios_1;
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

	@Column(name = "nome", nullable = false, length = 20)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "admin", nullable = false, length = 2)
	public String getAdmin() {
		return this.admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuariofuncao", catalog = "trabalho", joinColumns = {
			@JoinColumn(name = "Funcao_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Usuario_id", nullable = false, updatable = false) })
	public Set<UsuarioEntity> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuariofuncao", catalog = "trabalho", joinColumns = {
			@JoinColumn(name = "Funcao_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Usuario_id", nullable = false, updatable = false) })
	public Set<UsuarioEntity> getUsuarios_1() {
		return this.usuarios_1;
	}

	public void setUsuarios_1(Set<UsuarioEntity> usuarios_1) {
		this.usuarios_1 = usuarios_1;
	}

}
