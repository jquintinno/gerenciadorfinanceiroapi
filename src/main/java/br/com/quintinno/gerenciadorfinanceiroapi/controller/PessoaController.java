package br.com.quintinno.gerenciadorfinanceiroapi.controller;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TipoPessoaDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@GetMapping("/tipo")
	public List<TipoPessoaDomain> recuperarTipoPessoa() {
		return this.pessoaService.recuperarTipoPessoa();
	}
	
}
