package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TIPO_PESSOA")
public class TipoPessoaDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_TIPO_PESSOA", sequenceName = "SQ_TIPO_PESSOA", allocationSize = 1)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@Column(name = "DESCRICAO", length = 50, nullable = false)
	private String descricao;
	
	public TipoPessoaDomain() { }

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
