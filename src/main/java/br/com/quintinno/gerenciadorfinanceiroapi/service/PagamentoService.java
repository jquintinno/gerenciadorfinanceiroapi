package br.com.quintinno.gerenciadorfinanceiroapi.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.PagamentoDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.ParcelamentoDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ParcelamentoService parcelamentoService;
	
	public PagamentoDomain realizarPagamentoParcela(PagamentoDomain pagamentoDomain) {
		ParcelamentoDomain parcelamentoDomain = this.parcelamentoService.searchOne(pagamentoDomain.getParcelamentoDomain().getCodigo());
		if (parcelamentoDomain != null) {
			parcelamentoDomain.setDataPagamento(LocalDate.now());
		}
		this.parcelamentoService.updateOne(parcelamentoDomain);
		return this.pagamentoRepository.save(pagamentoDomain);
	}
	
}
