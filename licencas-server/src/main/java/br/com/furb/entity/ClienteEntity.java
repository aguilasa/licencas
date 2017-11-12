package br.com.furb.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente", catalog = "trabalho")
public class ClienteEntity implements java.io.Serializable {

	private Integer id;
	private String nome;
	private String tipo;
	private String cnpjCpf;
	private Set<PedidoEntity> pedidos = new HashSet<PedidoEntity>(0);
	private Set<PedidoEntity> pedidos_1 = new HashSet<PedidoEntity>(0);

	public ClienteEntity() {
	}

	public ClienteEntity(String nome, String tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	public ClienteEntity(String nome, String tipo, String cnpjCpf, Set<PedidoEntity> pedidos, Set<PedidoEntity> pedidos_1) {
		this.nome = nome;
		this.tipo = tipo;
		this.cnpjCpf = cnpjCpf;
		this.pedidos = pedidos;
		this.pedidos_1 = pedidos_1;
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

	@Column(name = "tipo", nullable = false, length = 2)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "cnpjCpf", length = 18)
	public String getCnpjCpf() {
		return this.cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public Set<PedidoEntity> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public Set<PedidoEntity> getPedidos_1() {
		return this.pedidos_1;
	}

	public void setPedidos_1(Set<PedidoEntity> pedidos_1) {
		this.pedidos_1 = pedidos_1;
	}

}
