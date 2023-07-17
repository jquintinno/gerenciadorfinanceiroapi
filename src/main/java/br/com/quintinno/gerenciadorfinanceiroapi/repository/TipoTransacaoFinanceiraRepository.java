package br.com.quintinno.gerenciadorfinanceiroapi.repository;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.TipoTransacaoFinanceiraDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTransacaoFinanceiraRepository extends JpaRepository<TipoTransacaoFinanceiraDomain, Long>{ }
