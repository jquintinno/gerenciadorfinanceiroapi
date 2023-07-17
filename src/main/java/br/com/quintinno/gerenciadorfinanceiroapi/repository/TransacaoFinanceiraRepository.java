package br.com.quintinno.gerenciadorfinanceiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.TransacaoFinanceiraDomain;

@Repository
public interface TransacaoFinanceiraRepository extends JpaRepository<TransacaoFinanceiraDomain, Long>{ }
