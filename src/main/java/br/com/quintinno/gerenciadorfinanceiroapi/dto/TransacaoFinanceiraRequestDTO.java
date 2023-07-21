package br.com.quintinno.gerenciadorfinanceiroapi.dto;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TipoTransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraProdutoServicoDomain;

public class TransacaoFinanceiraRequestDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private TipoTransacaoFinanceiraDomain tipoTransacaoFinanceiraDomain;
	
	private PessoaDomain pessoaTransacaoFinanceira;
	
	private PessoaDomain pessoaResponsavel;
	
	@JsonIgnore
	private Set<TransacaoFinanceiraProdutoServicoDomain> transacaoFinanceiraProdutoServicoDomainList = new HashSet<>();
	
	private String identificador;
	
	private Integer quantidadeParcela;
	
	private LocalDateTime dataHoraCadastro;
	
	private BigDecimal valorUnitario;
	
	private Integer diaVencimento;
	
	private Boolean bolTotalmentePago;
	
	private String observacao;
	
	public TransacaoFinanceiraRequestDTO() { }

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

	public Set<TransacaoFinanceiraProdutoServicoDomain> getTransacaoFinanceiraProdutoServicoDomainList() {
		return transacaoFinanceiraProdutoServicoDomainList;
	}

	public void setTransacaoFinanceiraProdutoServicoDomainList(
			Set<TransacaoFinanceiraProdutoServicoDomain> transacaoFinanceiraProdutoServicoDomainList) {
		this.transacaoFinanceiraProdutoServicoDomainList = transacaoFinanceiraProdutoServicoDomainList;
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

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Boolean getBolTotalmentePago() {
		return bolTotalmentePago;
	}

	public void setBolTotalmentePago(Boolean bolTotalmentePago) {
		this.bolTotalmentePago = bolTotalmentePago;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
