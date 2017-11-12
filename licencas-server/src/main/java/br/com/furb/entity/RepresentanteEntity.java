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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "representante", catalog = "trabalho")
public class RepresentanteEntity implements java.io.Serializable {

	private Integer id;
	private String nome;
	private String cpf;
	private Set<EstoqueEntity> estoques = new HashSet<EstoqueEntity>(0);
	private Set<PedidoEntity> pedidos = new HashSet<PedidoEntity>(0);
	private Set<PedidoEntity> pedidos_1 = new HashSet<PedidoEntity>(0);
	private Set<EstoqueEntity> estoques_1 = new HashSet<EstoqueEntity>(0);
	private Set<UsuarioEntity> usuarios = new HashSet<UsuarioEntity>(0);
	private Set<UsuarioEntity> usuarios_1 = new HashSet<UsuarioEntity>(0);

	public RepresentanteEntity() {
	}

	public RepresentanteEntity(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public RepresentanteEntity(String nome, String cpf, Set<EstoqueEntity> estoques, Set<PedidoEntity> pedidos, Set<PedidoEntity> pedidos_1,
			Set<EstoqueEntity> estoques_1, Set<UsuarioEntity> usuarios, Set<UsuarioEntity> usuarios_1) {
		this.nome = nome;
		this.cpf = cpf;
		this.estoques = estoques;
		this.pedidos = pedidos;
		this.pedidos_1 = pedidos_1;
		this.estoques_1 = estoques_1;
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

	@Column(name = "nome", nullable = false, length = 100)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "cpf", nullable = false, length = 14)
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "representante")
	public Set<EstoqueEntity> getEstoques() {
		return this.estoques;
	}

	public void setEstoques(Set<EstoqueEntity> estoques) {
		this.estoques = estoques;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "representante")
	public Set<PedidoEntity> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "representante")
	public Set<PedidoEntity> getPedidos_1() {
		return this.pedidos_1;
	}

	public void setPedidos_1(Set<PedidoEntity> pedidos_1) {
		this.pedidos_1 = pedidos_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "representante")
	public Set<EstoqueEntity> getEstoques_1() {
		return this.estoques_1;
	}

	public void setEstoques_1(Set<EstoqueEntity> estoques_1) {
		this.estoques_1 = estoques_1;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuariorepresentante", catalog = "trabalho", joinColumns = {
			@JoinColumn(name = "Representante_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Usuario_id", nullable = false, updatable = false) })
	public Set<UsuarioEntity> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuariorepresentante", catalog = "trabalho", joinColumns = {
			@JoinColumn(name = "Representante_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Usuario_id", nullable = false, updatable = false) })
	public Set<UsuarioEntity> getUsuarios_1() {
		return this.usuarios_1;
	}

	public void setUsuarios_1(Set<UsuarioEntity> usuarios_1) {
		this.usuarios_1 = usuarios_1;
	}

}
