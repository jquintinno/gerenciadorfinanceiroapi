package br.com.quintinno.gerenciadorfinanceiroapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TransacaoFinanceiraRepository;

@Service
public class TransacaoFinanceiraService {
	
	@Autowired
	private TransacaoFinanceiraRepository transacaoFinanceiraRepository;
	
	public TransacaoFinanceiraDomain createOne(TransacaoFinanceiraDomain transacaoFinanceiraDomain) {
		return this.transacaoFinanceiraRepository.save(transacaoFinanceiraDomain);
	}
	
	public List<TransacaoFinanceiraDomain> searchAll() {
		return this.transacaoFinanceiraRepository.findAll();
	}
	
}
