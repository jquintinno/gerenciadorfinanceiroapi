package br.com.quintinno.gerenciadorfinanceiroapi.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.ParcelamentoDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.enumeration.TipoTransacaoFinanceiraEnumeration;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.ParcelamentoRepository;
import br.com.quintinno.gerenciadorfinanceiroapi.utility.DateUtility;
import jakarta.transaction.Transactional;

@Service
public class ParcelamentoService {
	
	@Autowired
	private ParcelamentoRepository parcelamentoRepository;
	
	private static final String PREFIXO = "PARCELAMENTO";
	
	@Transactional
	public void gerarParcelamentoTransacaoFinanceira(TransacaoFinanceiraDomain transacaoFinanceiraDomain, Integer numeroParcela) {
		ParcelamentoDomain parcelamentoDomain = new ParcelamentoDomain();
			parcelamentoDomain.setTransacaoFinanceiraDomain(transacaoFinanceiraDomain);
			parcelamentoDomain.setIdentificador(this.gerarIdentificador());
			parcelamentoDomain.setNumero(numeroParcela);
			parcelamentoDomain.setValor(transacaoFinanceiraDomain.getValorUnitario());
			transacaoFinanceiraDomain.setDataHoraCadastro(LocalDateTime.now());
			Boolean bolMesAtual = transacaoFinanceiraDomain.getTipoTransacaoFinanceiraDomain().getCodigo() == TipoTransacaoFinanceiraEnumeration.DESPESA_VARIAVEL.getCodigo() && transacaoFinanceiraDomain.getQuantidadeParcela() == 1 ? true : false;
			parcelamentoDomain.setDataVencimento(this.gerarDataVencimento(transacaoFinanceiraDomain.getDiaVencimento(), transacaoFinanceiraDomain.getDataHoraCadastro(), numeroParcela, bolMesAtual));	
			this.parcelamentoRepository.save(parcelamentoDomain);
	}
	
	private String gerarIdentificador() {
		return PREFIXO.concat(DateUtility.recuperarDataAtual(DateUtility.FORMATO_B));
	}
	
	private LocalDate gerarDataVencimento(Integer diaVencimento, LocalDateTime dataHoraCadastro, int index, Boolean bolMesAtual) {
		return bolMesAtual ? dataHoraCadastro.toLocalDate() : dataHoraCadastro.toLocalDate().plusMonths(index);
	}

}
