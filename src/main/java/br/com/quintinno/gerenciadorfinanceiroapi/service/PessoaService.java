package br.com.quintinno.gerenciadorfinanceiroapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public PessoaDomain createOne(PessoaDomain pessoaDomain) {
		return this.pessoaRepository.save(pessoaDomain);
	}
	
	public List<PessoaDomain> searchAll() {
		return this.pessoaRepository.findAll();
	}
	
}
