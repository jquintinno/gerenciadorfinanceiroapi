package br.com.quintinno.gerenciadorfinanceiroapi.dto;

import java.util.HashSet;
import java.util.Set;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraProdutoServicoDomain;

public class TransacaoFinanceiraProdutoServicoRequestDTO {

	private Set<TransacaoFinanceiraProdutoServicoDomain> transacaoFinanceiraProdutoServicoDomainList = new HashSet<>();
	
	public TransacaoFinanceiraProdutoServicoRequestDTO() { }

	public Set<TransacaoFinanceiraProdutoServicoDomain> getTransacaoFinanceiraProdutoServicoDomainList() {
		return transacaoFinanceiraProdutoServicoDomainList;
	}

	public void setTransacaoFinanceiraProdutoServicoDomainList(Set<TransacaoFinanceiraProdutoServicoDomain> transacaoFinanceiraProdutoServicoDomainList) {
		this.transacaoFinanceiraProdutoServicoDomainList = transacaoFinanceiraProdutoServicoDomainList;
	}

}
