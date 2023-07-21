package br.com.quintinno.gerenciadorfinanceiroapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.ContaBancariaDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.ContaBancariaRepostory;

@Service
public class ContaBancariaService {
	
	@Autowired
	private ContaBancariaRepostory contaBancariaRepostory;
	
	public ContaBancariaDomain createOneContaBancaria(ContaBancariaDomain contaBancariaDomain) {
		return this.contaBancariaRepostory.save(contaBancariaDomain);
	}
	
	public List<ContaBancariaDomain> searchAllContaBancaria() {
		return this.contaBancariaRepostory.findAll();
	}
	
}
