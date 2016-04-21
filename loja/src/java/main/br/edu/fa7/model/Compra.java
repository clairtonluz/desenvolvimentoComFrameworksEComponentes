package br.edu.fa7.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.edu.fa7.model.vo.ClienteVO;

@Entity
@Table(name="compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="produto_id" , insertable = false , updatable = false)
	private Integer produtoId;
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	@Column(name="cliente_id" )
	private Integer clienteId;
	@Transient
	private ClienteVO cliente;
	
	private Double valor;

	public Compra() {	}
	
	
	@Override
	public String toString() {
		return "Compra [id=" + id + ", produtoId=" + produtoId + ", cliente=" + cliente + ", valor=" + valor + "]";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	
}
