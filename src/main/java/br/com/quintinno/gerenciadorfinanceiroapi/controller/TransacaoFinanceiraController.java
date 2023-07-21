package br.com.quintinno.gerenciadorfinanceiroapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.TipoTransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.dto.TransacaoFinanceiraRequestDTO;
import br.com.quintinno.gerenciadorfinanceiroapi.service.TransacaoFinanceiraService;

@RestController
@RequestMapping("/transacao-financeira")
public class TransacaoFinanceiraController {

	@Autowired
	private TransacaoFinanceiraService transacaoFinanceiraService;
	
	@PostMapping
	private TransacaoFinanceiraDomain createOne(@RequestBody TransacaoFinanceiraRequestDTO transacaoFinanceiraRequestDTO) {
		return this.transacaoFinanceiraService.createOne(transacaoFinanceiraRequestDTO);
	}
	
	@GetMapping
	private List<TransacaoFinanceiraDomain> searchAll() {
		return this.transacaoFinanceiraService.searchAll();
	}

	@GetMapping("/tipo")
	public List<TipoTransacaoFinanceiraDomain> recuperarTipoTransacaoFinanceira() {
		return this.transacaoFinanceiraService.recuperarTipoTransacaoFinanceira();
	}
	
	@GetMapping("/{codigoTransacaoFinanceira}")
	public TransacaoFinanceiraDomain searchOne(@PathVariable("codigoTransacaoFinanceira") Long codigoTransacaoFinanceira) {
		return this.transacaoFinanceiraService.searchOne(codigoTransacaoFinanceira);
	}

}
