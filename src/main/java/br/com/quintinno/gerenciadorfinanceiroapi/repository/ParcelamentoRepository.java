package br.com.quintinno.gerenciadorfinanceiroapi.repository;

import br.com.quintinno.gerenciadorfinanceiroapi.domain.ParcelamentoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelamentoRepository extends JpaRepository<ParcelamentoDomain, Long>{ }
