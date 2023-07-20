package br.com.quintinno.gerenciadorfinanceiroapi.enumeration;

public enum TipoTransacaoFinanceiraEnumeration {
	
	RECEITA_FIXA (1L), 
	RECEITA_VARIAVEL (2L),
	DESPESA_FIXA (3L),
	DESPESA_VARIAVEL (4L),
	CONCESSAO_EMPRESTIMO_PESSOA_FISICA (5L),
	CONCESSAO_EMPRESTIMO_PESSOA_JURIDICA (6L),
	ADQUIRICAO_EMPRESTIMO_PESSOA_FISICA (7L),
	ADQUIRICAO_EMPRESTIMO_PESSOA_JURIDICA (8L);
	
	private Long codigo;

	private TipoTransacaoFinanceiraEnumeration(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
}
