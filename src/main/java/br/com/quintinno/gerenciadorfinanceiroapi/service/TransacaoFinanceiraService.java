package br.com.quintinno.gerenciadorfinanceiroapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.TipoTransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TipoTransacaoFinanceiraImplementationRepository;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TipoTransacaoFinanceiraRepository;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TransacaoFinanceiraRepository;
import br.com.quintinno.gerenciadorfinanceiroapi.utility.DateUtility;

@Service
public class TransacaoFinanceiraService {
	
	@Autowired
	private TransacaoFinanceiraRepository transacaoFinanceiraRepository;

	@Autowired
	private TipoTransacaoFinanceiraRepository tipoTransacaoFinanceiraRepository;
	
	@Autowired
	private TipoTransacaoFinanceiraImplementationRepository transacaoFinanceiraImplementationRepository;
	
	public TransacaoFinanceiraDomain createOne(TransacaoFinanceiraDomain transacaoFinanceiraDomain) {
			transacaoFinanceiraDomain.setDataHoraCadastro(LocalDateTime.now());
			transacaoFinanceiraDomain.setIdentificador(this.gerarIdentificador());
		return this.transacaoFinanceiraRepository.save(transacaoFinanceiraDomain);
	}
	
	public List<TransacaoFinanceiraDomain> searchAll() {
		return this.transacaoFinanceiraRepository.findAll();
	}

	public List<TipoTransacaoFinanceiraDomain> recuperarTipoTransacaoFinanceira() {
		return this.tipoTransacaoFinanceiraRepository.findAll();
	}
	
	public TransacaoFinanceiraDomain searchOne(Long codigoTransacaoFinanceira) {
		return this.transacaoFinanceiraRepository.findById(codigoTransacaoFinanceira).orElse(null);
	}
	
	/**
	 * Regra: Deve ser gerado da seguinte forma: 
	 * 	TRAFIN+{DATA_TRANSACAO}+{CODIGO_TRANSACAO_DIARIO}
	 * Exeplo: TRANSACAOFINANCEIRA0004190720230001
	 * @param codigoTransacaoFinanceira
	 * @return
	 */
	private String gerarIdentificador() {
		Long codigoTransacaoFinanceira = this.transacaoFinanceiraImplementationRepository.recuperarUltimoTransacaoDiaria();
		String dataAtual = DateUtility.recuperarDataAtual(DateUtility.FORMATO_A);
		if (Long.valueOf(codigoTransacaoFinanceira) < 9) {
			return "TRAFIN".concat(dataAtual).concat("000").concat(String.valueOf(codigoTransacaoFinanceira+1));
		} else {
			return "TRANSACAOFINANCEIRA".concat(dataAtual).concat("00").concat(String.valueOf(codigoTransacaoFinanceira+1));
		}
	}
	
}
