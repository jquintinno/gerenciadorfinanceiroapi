package br.com.quintinno.gerenciadorfinanceiroapi.controller;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.TipoTransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.service.TransacaoFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao-financeira")
public class TransacaoFinanceiraController {

	@Autowired
	private TransacaoFinanceiraService transacaoFinanceiraService;
	
	@PostMapping
	private TransacaoFinanceiraDomain createOne(@RequestBody TransacaoFinanceiraDomain transacaoFinanceiraDomain) {
		return this.transacaoFinanceiraService.createOne(transacaoFinanceiraDomain);
	}
	
	@GetMapping
	private List<TransacaoFinanceiraDomain> searchAll() {
		return this.transacaoFinanceiraService.searchAll();
	}

	@GetMapping("/tipo")
	public List<TipoTransacaoFinanceiraDomain> recuperarTipoTransacaoFinanceira() {
		return this.transacaoFinanceiraService.recuperarTipoTransacaoFinanceira();
	}

}
