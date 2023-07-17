package br.com.quintinno.gerenciadorfinanceiroapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.service.TransacaoFinanceiraService;

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
	
}
