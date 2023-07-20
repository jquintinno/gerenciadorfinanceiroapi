package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_PARCELAMENTO", schema = "public")
public class ParcelamentoDomain implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@OneToOne
	@JoinColumn(name = "ID_TRANSACAO_FINANCEIRA")
	private TransacaoFinanceiraDomain transacaoFinanceiraDomain;

	@Column(name = "IDENTIFICADOR", nullable = false)
	private String identificador;

	@Column(name = "NUMERO", nullable = false)
	private Integer numero;

	@Column(name = "VALOR", nullable = false)
	private BigDecimal valor;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_VENCIMENTO")
	private LocalDate dataVencimento;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_PAGAMENTO")
	private LocalDate dataPagamento;

	public ParcelamentoDomain() { }

	public ParcelamentoDomain(String identificador, Integer numero, BigDecimal valor, LocalDate dataVencimento, LocalDate dataPagamento) {
		this.identificador = identificador;
		this.numero = numero;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public TransacaoFinanceiraDomain getTransacaoFinanceiraDomain() {
		return transacaoFinanceiraDomain;
	}

	public void setTransacaoFinanceiraDomain(TransacaoFinanceiraDomain transacaoFinanceiraDomain) {
		this.transacaoFinanceiraDomain = transacaoFinanceiraDomain;
	}

}
