package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "public", name = "TB_PRODUTO_SERVICO")
public class ProdutoServicoDomain implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;

	@JsonIgnore
	@OneToMany(mappedBy = "produtoServicoDomain")
	private Set<TransacaoFinanceiraProdutoServicoDomain> transacaoFinanceiraProdutoServicoDomainList = new HashSet<>();

	@Column(name = "NOME", length = 100, unique = true, nullable = false)
	private String nome;
	
	public ProdutoServicoDomain() { }

	public ProdutoServicoDomain(String nome) {
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<TransacaoFinanceiraProdutoServicoDomain> getTransacaoFinanceiraProdutoServicoDomainList() {
		return transacaoFinanceiraProdutoServicoDomainList;
	}

	public void setTransacaoFinanceiraProdutoServicoDomainList(
			Set<TransacaoFinanceiraProdutoServicoDomain> transacaoFinanceiraProdutoServicoDomainList) {
		this.transacaoFinanceiraProdutoServicoDomainList = transacaoFinanceiraProdutoServicoDomainList;
	}
	
}
