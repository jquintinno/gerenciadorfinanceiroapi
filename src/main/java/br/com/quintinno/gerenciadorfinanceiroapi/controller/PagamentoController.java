package br.com.quintinno.gerenciadorfinanceiroapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.PagamentoDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	private PagamentoService pagamentoService;
	
	@PostMapping
	private PagamentoDomain createOne(@RequestBody PagamentoDomain pagamentoDomain) {
		return this.pagamentoService.realizarPagamentoParcela(pagamentoDomain);
	}

}
