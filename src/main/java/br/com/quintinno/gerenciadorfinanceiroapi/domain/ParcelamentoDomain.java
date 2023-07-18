package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_PARCELAMENTO", schema = "public")
public class ParcelamentoDomain implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;

	@Column(name = "IDENTIFICADOR", nullable = false)
	private String identificador;

	@Column(name = "NUMERO", nullable = false)
	private String numero;

	@Column(name = "VALOR", nullable = false)
	private BigDecimal valor;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_VENCIMENTO", nullable = false)
	private LocalDate dataVencimento;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_PAGAMENTO")
	private LocalDate dataPagamento;

	public ParcelamentoDomain() { }

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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

}
