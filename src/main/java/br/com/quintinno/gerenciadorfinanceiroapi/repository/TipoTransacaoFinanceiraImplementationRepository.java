package br.com.quintinno.gerenciadorfinanceiroapi.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class TipoTransacaoFinanceiraImplementationRepository { 
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Long recuperarUltimoTransacaoDiaria() {
		StringBuilder query = new StringBuilder("SELECT COUNT(transacaoFinanceiraDomain) + 1 ")
			.append("FROM TransacaoFinanceiraDomain transacaoFinanceiraDomain ")
			.append("WHERE TO_CHAR(transacaoFinanceiraDomain.dataHoraCadastro::DATE,'YYYY-MM-DD') = TO_CHAR(NOW()::DATE,'YYYY-MM-DD') ");
		TypedQuery<Long> typedQuery = this.entityManager.createQuery(query.toString(), Long.class);
		return typedQuery.getSingleResult();
	}
	
}
