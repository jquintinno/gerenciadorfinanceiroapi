package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
