package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PESSOA")
public class PessoaDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_PESSOA", sequenceName = "SQ_PESSOA", allocationSize = 1)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_PESSOA", nullable = false)
	private TipoPessoaDomain tipoPessoaDomain;
	
	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;
	
	public PessoaDomain() { }

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

}
