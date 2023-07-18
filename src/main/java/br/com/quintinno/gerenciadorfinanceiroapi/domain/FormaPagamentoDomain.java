package br.com.quintinno.gerenciadorfinanceiroapi.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "TB_FORMA_PAGAMENTO")
public class FormaPagamentoDomain implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;

	@Column(name = "descricao", length = 50, nullable = false)
	private String descricao;

	public FormaPagamentoDomain() { }

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
