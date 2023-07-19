package br.com.quintinno.gerenciadorfinanceiroapi;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.PessoaDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.ProdutoServicoDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TipoPessoaDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TipoTransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraProdutoServicoDomain;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.PessoaRepository;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TipoTransacaoFinanceiraRepository;
import br.com.quintinno.gerenciadorfinanceiroapi.repository.TransacaoFinanceiraRepository;

class ApplicationTests { 
	
	@Autowired
	private TransacaoFinanceiraRepository transacaoFinanceiraRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private TipoTransacaoFinanceiraRepository tipoTransacaoFinanceiraRepository;
	
	public void createTransacaoFinanceiraComProdutoServico() {
		
		PessoaDomain pessoaDomain1 = new PessoaDomain(new TipoPessoaDomain(1L), "José Quintinno");
		PessoaDomain pessoaDomain2 = new PessoaDomain(new TipoPessoaDomain(2L), "Supermercado PraVocê (Brazlândia)");
		
			pessoaRepository.saveAll(Arrays.asList(pessoaDomain1, pessoaDomain2));
		
		TipoTransacaoFinanceiraDomain tipoTransacaoFinanceiraDomain1 = this.tipoTransacaoFinanceiraRepository.findById(4L).get();
		
		ProdutoServicoDomain produtoServicoDomain1 = new ProdutoServicoDomain("Arroz Tio João 10KG");
		ProdutoServicoDomain produtoServicoDomain2 = new ProdutoServicoDomain("Feijão Delícia 2KG");
		ProdutoServicoDomain produtoServicoDomain3 = new ProdutoServicoDomain("Açucar Cristal 5KG");
		
		TransacaoFinanceiraDomain transacaoFinanceiraDomain1 = new TransacaoFinanceiraDomain();
			transacaoFinanceiraDomain1.setDataHoraCadastro(LocalDateTime.now());
			transacaoFinanceiraDomain1.seteRecorrente(false);
			transacaoFinanceiraDomain1.setEtotalmentePago(true);
			transacaoFinanceiraDomain1.setIdentificador("TRANSACAO_FINANCEIRA_001");
			transacaoFinanceiraDomain1.setObservacao(null);
			transacaoFinanceiraDomain1.setPessoaResponsavel(pessoaDomain1);
			transacaoFinanceiraDomain1.setPessoaTransacaoFinanceira(pessoaDomain2);
			transacaoFinanceiraDomain1.setQuantidadeParcela(1);
			transacaoFinanceiraDomain1.setTipoTransacaoFinanceiraDomain(tipoTransacaoFinanceiraDomain1);
			transacaoFinanceiraDomain1.setValorTotal(BigDecimal.valueOf(100.00));
			
		TransacaoFinanceiraProdutoServicoDomain transacaoFinanceiraProdutoServicoDomain1 = new TransacaoFinanceiraProdutoServicoDomain(transacaoFinanceiraDomain1, produtoServicoDomain1, BigDecimal.valueOf(26.99));
		TransacaoFinanceiraProdutoServicoDomain transacaoFinanceiraProdutoServicoDomain2 = new TransacaoFinanceiraProdutoServicoDomain(transacaoFinanceiraDomain1, produtoServicoDomain2, BigDecimal.valueOf(16.98));
		TransacaoFinanceiraProdutoServicoDomain transacaoFinanceiraProdutoServicoDomain3 = new TransacaoFinanceiraProdutoServicoDomain(transacaoFinanceiraDomain1, produtoServicoDomain3, BigDecimal.valueOf(14.59));
			
			transacaoFinanceiraDomain1.adicionarTransacaoFinanceiraProdutoServico(transacaoFinanceiraProdutoServicoDomain1);
			transacaoFinanceiraDomain1.adicionarTransacaoFinanceiraProdutoServico(transacaoFinanceiraProdutoServicoDomain2);
			transacaoFinanceiraDomain1.adicionarTransacaoFinanceiraProdutoServico(transacaoFinanceiraProdutoServicoDomain3);
			
			transacaoFinanceiraRepository.save(transacaoFinanceiraDomain1);
			
		Assertions.assertThat(transacaoFinanceiraDomain1.getCodigo()).isGreaterThan(0);
		
	}
	
}
