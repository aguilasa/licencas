package br.com.furb.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedido", catalog = "trabalho")
public class PedidoEntity implements java.io.Serializable {

	private Integer id;
	private ClienteEntity cliente;
	private RepresentanteEntity representante;
	private Date dataPedido;
	private Date prazoPedido;
	private Date entregaPedido;
	private String entregue;
	private Set<ItemProdutoEntity> itemprodutos = new HashSet<ItemProdutoEntity>(0);
	private Set<ItemProdutoEntity> itemprodutos_1 = new HashSet<ItemProdutoEntity>(0);

	public PedidoEntity() {
	}

	public PedidoEntity(ClienteEntity cliente, RepresentanteEntity representante, Date dataPedido, Date prazoPedido) {
		this.cliente = cliente;
		this.representante = representante;
		this.dataPedido = dataPedido;
		this.prazoPedido = prazoPedido;
	}

	public PedidoEntity(ClienteEntity cliente, RepresentanteEntity representante, Date dataPedido, Date prazoPedido, Date entregaPedido,
			String entregue, Set<ItemProdutoEntity> itemprodutos, Set<ItemProdutoEntity> itemprodutos_1) {
		this.cliente = cliente;
		this.representante = representante;
		this.dataPedido = dataPedido;
		this.prazoPedido = prazoPedido;
		this.entregaPedido = entregaPedido;
		this.entregue = entregue;
		this.itemprodutos = itemprodutos;
		this.itemprodutos_1 = itemprodutos_1;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Cliente_id", nullable = false)
	public ClienteEntity getCliente() {
		return this.cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Representante_id", nullable = false)
	public RepresentanteEntity getRepresentante() {
		return this.representante;
	}

	public void setRepresentante(RepresentanteEntity representante) {
		this.representante = representante;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_pedido", nullable = false, length = 10)
	public Date getDataPedido() {
		return this.dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "prazo_pedido", nullable = false, length = 10)
	public Date getPrazoPedido() {
		return this.prazoPedido;
	}

	public void setPrazoPedido(Date prazoPedido) {
		this.prazoPedido = prazoPedido;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "entrega_pedido", length = 10)
	public Date getEntregaPedido() {
		return this.entregaPedido;
	}

	public void setEntregaPedido(Date entregaPedido) {
		this.entregaPedido = entregaPedido;
	}

	@Column(name = "entregue", length = 2)
	public String getEntregue() {
		return this.entregue;
	}

	public void setEntregue(String entregue) {
		this.entregue = entregue;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	public Set<ItemProdutoEntity> getItemprodutos() {
		return this.itemprodutos;
	}

	public void setItemprodutos(Set<ItemProdutoEntity> itemprodutos) {
		this.itemprodutos = itemprodutos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	public Set<ItemProdutoEntity> getItemprodutos_1() {
		return this.itemprodutos_1;
	}

	public void setItemprodutos_1(Set<ItemProdutoEntity> itemprodutos_1) {
		this.itemprodutos_1 = itemprodutos_1;
	}

}
