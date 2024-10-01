package io.github.danieloliveira11.cartaos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.danieloliveira11.cartaos.domain.entity.ClienteCartaoEntity;

@Repository
public interface ClienteCartaoRepository extends JpaRepository<ClienteCartaoEntity, Long>{

	List<ClienteCartaoEntity> findByCpf(String cpf);

}
