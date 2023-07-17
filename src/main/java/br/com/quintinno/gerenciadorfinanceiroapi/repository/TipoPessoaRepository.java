package br.com.quintinno.gerenciadorfinanceiroapi.repository;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.TipoPessoaDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPessoaRepository extends JpaRepository<TipoPessoaDomain, Long>{ }
