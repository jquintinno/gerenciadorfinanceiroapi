package br.com.quintinno.gerenciadorfinanceiroapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.ProdutoServicoDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.ProdutoServicoRepository;

@Service
public class ProdutoServicoService {
	
	@Autowired
	private ProdutoServicoRepository produtoServicoRepository;
	
	public ProdutoServicoDomain createOne(ProdutoServicoDomain produtoServicoDomain) {
		return this.produtoServicoRepository.save(produtoServicoDomain);
	}
	
	public List<ProdutoServicoDomain> searchAll() {
		return this.produtoServicoRepository.findAll();
	}
	
	public ProdutoServicoDomain searchOne(Long codigoProdutoServico) {
		return this.produtoServicoRepository.findById(codigoProdutoServico).orElseThrow();
	}
	
}
