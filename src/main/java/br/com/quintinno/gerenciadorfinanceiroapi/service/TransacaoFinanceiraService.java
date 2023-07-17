package br.com.quintinno.gerenciadorfinanceiroapi.service;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.TipoTransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TipoTransacaoFinanceiraRepository;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TransacaoFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransacaoFinanceiraService {
	
	@Autowired
	private TransacaoFinanceiraRepository transacaoFinanceiraRepository;

	@Autowired
	private TipoTransacaoFinanceiraRepository tipoTransacaoFinanceiraRepository;
	
	public TransacaoFinanceiraDomain createOne(TransacaoFinanceiraDomain transacaoFinanceiraDomain) {
		transacaoFinanceiraDomain.setDataHoraCadastro(LocalDateTime.now());
		return this.transacaoFinanceiraRepository.save(transacaoFinanceiraDomain);
	}
	
	public List<TransacaoFinanceiraDomain> searchAll() {
		return this.transacaoFinanceiraRepository.findAll();
	}

	public List<TipoTransacaoFinanceiraDomain> recuperarTipoTransacaoFinanceira() {
		return this.tipoTransacaoFinanceiraRepository.findAll();
	}
	
}
