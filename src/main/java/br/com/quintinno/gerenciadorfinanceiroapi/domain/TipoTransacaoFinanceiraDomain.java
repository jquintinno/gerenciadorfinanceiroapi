package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_TIPO_TRANSACAO_FINANCEIRA")
public class TipoTransacaoFinanceiraDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@Column(name = "DESCRICAO", length = 50, nullable = false)
	private String descricao;
	
	public TipoTransacaoFinanceiraDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
