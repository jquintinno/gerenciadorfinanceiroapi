package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
	
	@OneToMany(mappedBy = "transacaoFinanceiraDomain", cascade = CascadeType.ALL)
	private Set<TransacaoFinanceiraProdutoServicoDomain> transacaoFinanceiraProdutoServicoDomainList = new HashSet<>();
	
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
	
	public void adicionarTransacaoFinanceiraProdutoServico(TransacaoFinanceiraProdutoServicoDomain transacaoFinanceiraProdutoServicoDomain) {
		this.transacaoFinanceiraProdutoServicoDomainList.add(transacaoFinanceiraProdutoServicoDomain);
	}

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

	public Boolean getEtotalmentePago() {
		return eTotalmentePago;
	}

	public void setEtotalmentePago(Boolean eTotalmentePago) {
		this.eTotalmentePago = eTotalmentePago;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Set<TransacaoFinanceiraProdutoServicoDomain> getTransacaoFinanceiraProdutoServicoDomainList() {
		return transacaoFinanceiraProdutoServicoDomainList;
	}

	public void setTransacaoFinanceiraProdutoServicoDomainList(
			Set<TransacaoFinanceiraProdutoServicoDomain> transacaoFinanceiraProdutoServicoDomainList) {
		this.transacaoFinanceiraProdutoServicoDomainList = transacaoFinanceiraProdutoServicoDomainList;
	}

}
