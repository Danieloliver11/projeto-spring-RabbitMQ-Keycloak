package io.github.danieloliveira11.clientes.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.danieloliveira11.clientes.domain.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

	
	Optional<ClienteEntity> findByCpf(String cpf);

}
