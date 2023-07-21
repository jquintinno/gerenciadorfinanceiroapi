package br.com.quintinno.gerenciadorfinanceiroapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.TipoTransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraProdutoServicoDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.dto.TransacaoFinanceiraProdutoServicoRequestDTO;
import br.com.quintinno.gerenciadorfinanceiroapi.dto.TransacaoFinanceiraRequestDTO;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.ProdutoServicoRepository;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TipoTransacaoFinanceiraImplementationRepository;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TipoTransacaoFinanceiraRepository;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TransacaoFinanceiraProdutoServicoRepository;
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
	
	@Autowired
	private TransacaoFinanceiraProdutoServicoRepository transacaoFinanceiraProdutoServicoRepository;
	
	@Autowired
	private ProdutoServicoRepository produtoServicoRepository;
	
	private static final String PREFIXO = "TRANSACAOFINANCEIRA";
	
	@SuppressWarnings("unused")
	@Autowired
	private TipoTransacaoFinanceiraImplementationRepository transacaoFinanceiraImplementationRepository;
	
	@Transactional
	public TransacaoFinanceiraDomain createOne(TransacaoFinanceiraRequestDTO transacaoFinanceiraRequestDTO) {
		TransacaoFinanceiraDomain transacaoFinanceiraDomainPersist = this.configurarTransacaoFinanceira(transacaoFinanceiraRequestDTO);
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
	
	private TransacaoFinanceiraDomain configurarTransacaoFinanceira(TransacaoFinanceiraRequestDTO transacaoFinanceiraRequestDTO) {
		TransacaoFinanceiraDomain transacaoFinanceiraDomain = new TransacaoFinanceiraDomain();
			transacaoFinanceiraDomain.setBolTotalmentePago(transacaoFinanceiraRequestDTO.getBolTotalmentePago());
			transacaoFinanceiraDomain.setDataHoraCadastro(transacaoFinanceiraRequestDTO.getDataHoraCadastro());
			transacaoFinanceiraDomain.setDiaVencimento(transacaoFinanceiraRequestDTO.getDiaVencimento());
			transacaoFinanceiraDomain.setIdentificador(this.gerarIdentificador());
			transacaoFinanceiraDomain.setObservacao(transacaoFinanceiraRequestDTO.getObservacao());
			transacaoFinanceiraDomain.setPessoaResponsavel(transacaoFinanceiraRequestDTO.getPessoaResponsavel());
			transacaoFinanceiraDomain.setPessoaTransacaoFinanceira(transacaoFinanceiraRequestDTO.getPessoaTransacaoFinanceira());
			transacaoFinanceiraDomain.setQuantidadeParcela(transacaoFinanceiraRequestDTO.getQuantidadeParcela());
			transacaoFinanceiraDomain.setTipoTransacaoFinanceiraDomain(transacaoFinanceiraRequestDTO.getTipoTransacaoFinanceiraDomain());
			transacaoFinanceiraDomain.setTransacaoFinanceiraProdutoServicoDomainList(transacaoFinanceiraRequestDTO.getTransacaoFinanceiraProdutoServicoDomainList());
			transacaoFinanceiraDomain.setValorUnitario(transacaoFinanceiraRequestDTO.getValorUnitario());
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
	
	public TransacaoFinanceiraProdutoServicoDomain vincularProdutoServicoTransacaoFinanceira(TransacaoFinanceiraProdutoServicoRequestDTO transacaoFinanceiraProdutoServicoRequestDTO) {
		TransacaoFinanceiraProdutoServicoDomain transacaoFinanceiraProdutoServicoDomain = new TransacaoFinanceiraProdutoServicoDomain();
		for (TransacaoFinanceiraProdutoServicoDomain object : transacaoFinanceiraProdutoServicoRequestDTO.getTransacaoFinanceiraProdutoServicoDomainList()) {
				transacaoFinanceiraProdutoServicoDomain = new TransacaoFinanceiraProdutoServicoDomain();
				transacaoFinanceiraProdutoServicoDomain.setTransacaoFinanceiraDomain(this.transacaoFinanceiraRepository.findById(object.getTransacaoFinanceiraDomain().getCodigo()).orElseThrow());
				transacaoFinanceiraProdutoServicoDomain.setProdutoServicoDomain(this.produtoServicoRepository.findById(object.getProdutoServicoDomain().getCodigo()).orElseThrow());
				transacaoFinanceiraProdutoServicoDomain.setValor(object.getValor());
			this.transacaoFinanceiraProdutoServicoRepository.save(transacaoFinanceiraProdutoServicoDomain);
		}
		return transacaoFinanceiraProdutoServicoDomain;
	}
	
}
