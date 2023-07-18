package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "TB_PAGAMENTO")
public class PagamentoDomain implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "ID_PARCELAMENTO")
	private ParcelamentoDomain parcelamentoDomain;

	@ManyToOne
	@JoinColumn(name = "ID_TRANSACAO_FINANCEIRA")
	private TransacaoFinanceiraDomain transacaoFinanceiraDomain;

	@ManyToOne
	@JoinColumn(name = "ID_CONTA_BANCARIA")
	private ContaBancariaDomain contaBancariaDomain;

	@ManyToOne
	@JoinColumn(name = "ID_FORMA_PARCELAMENTO")
	private FormaPagamentoDomain formaPagamentoDomain;

	public PagamentoDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public ParcelamentoDomain getParcelamentoDomain() {
		return parcelamentoDomain;
	}

	public void setParcelamentoDomain(ParcelamentoDomain parcelamentoDomain) {
		this.parcelamentoDomain = parcelamentoDomain;
	}

	public TransacaoFinanceiraDomain getTransacaoFinanceiraDomain() {
		return transacaoFinanceiraDomain;
	}

	public void setTransacaoFinanceiraDomain(TransacaoFinanceiraDomain transacaoFinanceiraDomain) {
		this.transacaoFinanceiraDomain = transacaoFinanceiraDomain;
	}

	public ContaBancariaDomain getContaBancariaDomain() {
		return contaBancariaDomain;
	}

	public void setContaBancariaDomain(ContaBancariaDomain contaBancariaDomain) {
		this.contaBancariaDomain = contaBancariaDomain;
	}

	public FormaPagamentoDomain getFormaPagamentoDomain() {
		return formaPagamentoDomain;
	}

	public void setFormaPagamentoDomain(FormaPagamentoDomain formaPagamentoDomain) {
		this.formaPagamentoDomain = formaPagamentoDomain;
	}

}
