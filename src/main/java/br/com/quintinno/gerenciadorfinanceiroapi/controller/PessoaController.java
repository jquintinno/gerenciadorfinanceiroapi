package br.com.quintinno.gerenciadorfinanceiroapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	private PessoaDomain createOne(@RequestBody PessoaDomain pessoaDomain) {
		return this.pessoaService.createOne(pessoaDomain);
	}
	
	@GetMapping
	private List<PessoaDomain> searchAll() {
		return this.pessoaService.searchAll();
	}
	
}
