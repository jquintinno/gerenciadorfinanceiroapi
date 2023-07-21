package br.com.quintinno.gerenciadorfinanceiroapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.ContaBancariaDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.service.ContaBancariaService;

@RestController
@RequestMapping("/conta-bancaria")
public class ContaBancariaController {

	@Autowired
	private ContaBancariaService contaBancariaService;
	
	@PostMapping
	private ContaBancariaDomain createOne(@RequestBody ContaBancariaDomain contaBancariaDomain) {
		return this.contaBancariaService.createOneContaBancaria(contaBancariaDomain);
	}
	
	@GetMapping
	private List<ContaBancariaDomain> searchAll() {
		return this.contaBancariaService.searchAllContaBancaria();
	}
	
}
