package br.com.quintinno.gerenciadorfinanceiroapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.TipoTransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TipoTransacaoFinanceiraImplementationRepository;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TipoTransacaoFinanceiraRepository;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TransacaoFinanceiraRepository;
import br.com.quintinno.gerenciadorfinanceiroapi.utility.DateUtility;
import jakarta.transaction.Transactional;

@Service
public class TransacaoFinanceiraService {
	
	@Autowired
	private TransacaoFinanceiraRepository transacaoFinanceiraRepository;

	@Autowired
	private TipoTransacaoFinanceiraRepository tipoTransacaoFinanceiraRepository;
	
	@Autowired
	private ParcelamentoService parcelamentoService;
	
	private static final String PREFIXO = "TRANSACAOFINANCEIRA";
	
	@SuppressWarnings("unused")
	@Autowired
	private TipoTransacaoFinanceiraImplementationRepository transacaoFinanceiraImplementationRepository;
	
	@Transactional
	public TransacaoFinanceiraDomain createOne(TransacaoFinanceiraDomain transacaoFinanceiraDomain) {
		TransacaoFinanceiraDomain transacaoFinanceiraDomainPersist = this.configurarTransacaoFinanceira(transacaoFinanceiraDomain);
			this.transacaoFinanceiraRepository.save(transacaoFinanceiraDomainPersist);
			this.gerarParcelamentoTransacaoFinanceira(transacaoFinanceiraDomainPersist);
		return transacaoFinanceiraDomainPersist;
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
	
	private TransacaoFinanceiraDomain configurarTransacaoFinanceira(TransacaoFinanceiraDomain transacaoFinanceiraDomain) {
		transacaoFinanceiraDomain.setIdentificador(this.gerarIdentificador());
		return transacaoFinanceiraDomain;
	}
	
	/**
	 * Regra: Deve ser gerado da seguinte forma: 
	 * 	TRAFIN<AAAAMMDDHHMMSS>
	 * Exemplo: TRANSACAOFINANCEIRA419072023191808
	 * @param codigoTransacaoFinanceira
	 * @return
	 */
	private String gerarIdentificador() {
		return PREFIXO.concat(DateUtility.recuperarDataAtual(DateUtility.FORMATO_B));
	}
	
	// TODO -- Corrigir: Passar Regra Negocial para a classe ParcelamentoService 
	private void gerarParcelamentoTransacaoFinanceira(TransacaoFinanceiraDomain transacaoFinanceiraDomain) {
//		if (transacaoFinanceiraDomain.getTipoTransacaoFinanceiraDomain().getCodigo() == TipoTransacaoFinanceiraEnumeration.DESPESA_VARIAVEL.getCodigo() 
//				&& transacaoFinanceiraDomain.getQuantidadeParcela() == 1) {
			controleParcelamento(transacaoFinanceiraDomain, 1);
//		} else {
//			controleParcelamento(transacaoFinanceiraDomain, 1);
//		}
	}

	private void controleParcelamento(TransacaoFinanceiraDomain transacaoFinanceiraDomain, int numeroControle) {
		for(int index = numeroControle ; index <= transacaoFinanceiraDomain.getQuantidadeParcela() ; index++) {
			this.parcelamentoService.gerarParcelamentoTransacaoFinanceira(transacaoFinanceiraDomain, index);
		}
	}
	
}
