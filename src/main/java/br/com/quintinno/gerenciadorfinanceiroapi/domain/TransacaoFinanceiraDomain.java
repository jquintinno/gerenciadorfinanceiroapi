package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_TRANSACAO_FINANCEIRA")
public class TransacaoFinanceiraDomain implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_TRANSACAO_FINANCEIRA")
	private TipoTransacaoFinanceiraDomain tipoTransacaoFinanceiraDomain;
	
	@ManyToOne
	@JoinColumn(name = "ID_PESSOA_TRANSACAO_FINANCEIRA")
	private PessoaDomain pessoaTransacaoFinanceira;
	
	@ManyToOne
	@JoinColumn(name = "ID_PESSOA_RESPONSAVEL")
	private PessoaDomain pessoaResponsavel;
	
	@Column(name = "IDENTIFICADOR", length = 50, nullable = false)
	private String identificador;
	
	@Column(name = "QUANTIDADE_PARCELA", nullable = false)
	private Integer quantidadeParcela;
	
	@Column(name = "DATA_HORA_CADASTRO", nullable = false)
	private LocalDateTime dataHoraCadastro;
	
	@Column(name = "VALOR_TOTAL", nullable = false)
	private BigDecimal valorTotal;
	
	@Column(name = "E_RECORRENTE", nullable = false)
	private Boolean eRecorrente;
	
	@Column(name = "E_TOTALMENTE_PAGO", nullable = false)
	private Boolean eTotalmentePago;
	
	@Column(name = "OBSERVACAO", length = 255)
	private String observacao;
	
	public TransacaoFinanceiraDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TipoTransacaoFinanceiraDomain getTipoTransacaoFinanceiraDomain() {
		return tipoTransacaoFinanceiraDomain;
	}

	public void setTipoTransacaoFinanceiraDomain(TipoTransacaoFinanceiraDomain tipoTransacaoFinanceiraDomain) {
		this.tipoTransacaoFinanceiraDomain = tipoTransacaoFinanceiraDomain;
	}

	public PessoaDomain getPessoaTransacaoFinanceira() {
		return pessoaTransacaoFinanceira;
	}

	public void setPessoaTransacaoFinanceira(PessoaDomain pessoaTransacaoFinanceira) {
		this.pessoaTransacaoFinanceira = pessoaTransacaoFinanceira;
	}

	public PessoaDomain getPessoaResponsavel() {
		return pessoaResponsavel;
	}

	public void setPessoaResponsavel(PessoaDomain pessoaResponsavel) {
		this.pessoaResponsavel = pessoaResponsavel;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Integer getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(Integer quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Boolean geteRecorrente() {
		return eRecorrente;
	}

	public void seteRecorrente(Boolean eRecorrente) {
		this.eRecorrente = eRecorrente;
	}

	public Boolean geteTotalmentePago() {
		return eTotalmentePago;
	}

	public void seteTotalmentePago(Boolean eTotalmentePago) {
		this.eTotalmentePago = eTotalmentePago;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
