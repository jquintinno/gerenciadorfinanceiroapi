package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TRANSACAO_FINANCEIRA_PRODUTO_SERVICO")
public class TransacaoFinanceiraProdutoServicoDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "ID_TRANSACAO_FINANCEIRA")
	private TransacaoFinanceiraDomain transacaoFinanceiraDomain;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PRODUTO_SERVICO")
	private ProdutoServicoDomain produtoServicoDomain;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Column(name = "VALOR", length = 50, nullable = false)
	private BigDecimal valor;
	
	public TransacaoFinanceiraProdutoServicoDomain() { }

	public TransacaoFinanceiraProdutoServicoDomain(TransacaoFinanceiraDomain transacaoFinanceiraDomain, ProdutoServicoDomain produtoServicoDomain, BigDecimal valor) {
		this.transacaoFinanceiraDomain = transacaoFinanceiraDomain;
		this.produtoServicoDomain = produtoServicoDomain;
		this.valor = valor;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TransacaoFinanceiraDomain getTransacaoFinanceiraDomain() {
		return transacaoFinanceiraDomain;
	}

	public void setTransacaoFinanceiraDomain(TransacaoFinanceiraDomain transacaoFinanceiraDomain) {
		this.transacaoFinanceiraDomain = transacaoFinanceiraDomain;
	}

	public ProdutoServicoDomain getProdutoServicoDomain() {
		return produtoServicoDomain;
	}

	public void setProdutoServicoDomain(ProdutoServicoDomain produtoServicoDomain) {
		this.produtoServicoDomain = produtoServicoDomain;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
