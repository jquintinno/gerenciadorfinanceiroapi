package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TB_PESSOA", schema = "public")
public class PessoaDomain implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_PESSOA", nullable = false)
	private TipoPessoaDomain tipoPessoaDomain;
	
	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;
	
	public PessoaDomain() { }

	public PessoaDomain(TipoPessoaDomain tipoPessoaDomain, String nome) {
		this.tipoPessoaDomain = tipoPessoaDomain;
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

	public TipoPessoaDomain getTipoPessoaDomain() {
		return tipoPessoaDomain;
	}

	public void setTipoPessoaDomain(TipoPessoaDomain tipoPessoaDomain) {
		this.tipoPessoaDomain = tipoPessoaDomain;
	}

}
