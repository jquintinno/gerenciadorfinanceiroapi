package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CONTA_BANCARIA", schema = "public")
public class ContaBancariaDomain implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "ID_PESSOA_CONTA_BANCARIA", nullable = false)
	private PessoaDomain pessoaContaBancaria;
	
	@ManyToOne
	@JoinColumn(name = "ID_PESSOA_TITULAR", nullable = false)
	private PessoaDomain pessoaTitular;
	
	@Column(name = "NUMERO", length = 20, unique = true, nullable = false)
	private String numero;
	
	@Column(name = "AGENCIA", length = 10, unique = true, nullable = false)
	private String agencia;
	
	@Column(name = "DATA_INICIO_CONTRATO")
	private LocalDate dataInicioContrato;
	
	@Column(name = "DATA_FIM_CONTRATO")
	private LocalDate dataFimContrato;
	
	public ContaBancariaDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public PessoaDomain getPessoaContaBancaria() {
		return pessoaContaBancaria;
	}

	public void setPessoaContaBancaria(PessoaDomain pessoaContaBancaria) {
		this.pessoaContaBancaria = pessoaContaBancaria;
	}

	public PessoaDomain getPessoaTitular() {
		return pessoaTitular;
	}

	public void setPessoaTitular(PessoaDomain pessoaTitular) {
		this.pessoaTitular = pessoaTitular;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public LocalDate getDataInicioContrato() {
		return dataInicioContrato;
	}

	public void setDataInicioContrato(LocalDate dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
	}

	public LocalDate getDataFimContrato() {
		return dataFimContrato;
	}

	public void setDataFimContrato(LocalDate dataFimContrato) {
		this.dataFimContrato = dataFimContrato;
	}

}
