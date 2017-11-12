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
@Table(name = "usuario", catalog = "trabalho")
public class UsuarioEntity implements java.io.Serializable {

	private Integer id;
	private String usuario;
	private String senha;
	private String ativo;
	private Set<RepresentanteEntity> representantes = new HashSet<RepresentanteEntity>(0);
	private Set<RepresentanteEntity> representantes_1 = new HashSet<RepresentanteEntity>(0);
	private Set<FuncaoEntity> funcaos = new HashSet<FuncaoEntity>(0);
	private Set<FuncaoEntity> funcaos_1 = new HashSet<FuncaoEntity>(0);

	public UsuarioEntity() {
	}

	public UsuarioEntity(String usuario, String senha, String ativo) {
		this.usuario = usuario;
		this.senha = senha;
		this.ativo = ativo;
	}

	public UsuarioEntity(String usuario, String senha, String ativo, Set<RepresentanteEntity> representantes,
			Set<RepresentanteEntity> representantes_1, Set<FuncaoEntity> funcaos, Set<FuncaoEntity> funcaos_1) {
		this.usuario = usuario;
		this.senha = senha;
		this.ativo = ativo;
		this.representantes = representantes;
		this.representantes_1 = representantes_1;
		this.funcaos = funcaos;
		this.funcaos_1 = funcaos_1;
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

	@Column(name = "usuario", nullable = false, length = 20)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "senha", nullable = false, length = 20)
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "ativo", nullable = false, length = 2)
	public String getAtivo() {
		return this.ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuariorepresentante", catalog = "trabalho", joinColumns = {
			@JoinColumn(name = "Usuario_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Representante_id", nullable = false, updatable = false) })
	public Set<RepresentanteEntity> getRepresentantes() {
		return this.representantes;
	}

	public void setRepresentantes(Set<RepresentanteEntity> representantes) {
		this.representantes = representantes;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuariorepresentante", catalog = "trabalho", joinColumns = {
			@JoinColumn(name = "Usuario_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Representante_id", nullable = false, updatable = false) })
	public Set<RepresentanteEntity> getRepresentantes_1() {
		return this.representantes_1;
	}

	public void setRepresentantes_1(Set<RepresentanteEntity> representantes_1) {
		this.representantes_1 = representantes_1;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuariofuncao", catalog = "trabalho", joinColumns = {
			@JoinColumn(name = "Usuario_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Funcao_id", nullable = false, updatable = false) })
	public Set<FuncaoEntity> getFuncaos() {
		return this.funcaos;
	}

	public void setFuncaos(Set<FuncaoEntity> funcaos) {
		this.funcaos = funcaos;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuariofuncao", catalog = "trabalho", joinColumns = {
			@JoinColumn(name = "Usuario_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Funcao_id", nullable = false, updatable = false) })
	public Set<FuncaoEntity> getFuncaos_1() {
		return this.funcaos_1;
	}

	public void setFuncaos_1(Set<FuncaoEntity> funcaos_1) {
		this.funcaos_1 = funcaos_1;
	}

}
