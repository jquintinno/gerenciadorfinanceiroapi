package br.com.quintinno.gerenciadorfinanceiroapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.ProdutoServicoDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.service.ProdutoServicoService;

@RestController
@RequestMapping("/produto-servico")
public class ProdutoServicoController {

	@Autowired
	private ProdutoServicoService produtoServicoService;
	
	@PostMapping
	private ProdutoServicoDomain createOne(@RequestBody ProdutoServicoDomain produtoServicoDomain) {
		return this.produtoServicoService.createOne(produtoServicoDomain);
	}
	
	@GetMapping
	private List<ProdutoServicoDomain> searchAll() {
		return this.produtoServicoService.searchAll();
	}
	
}
