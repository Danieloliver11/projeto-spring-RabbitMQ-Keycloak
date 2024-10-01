package io.github.danieloliveira11.cartaos.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.danieloliveira11.cartaos.domain.entity.CartaoEntity;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, Long> {

	List<CartaoEntity> findByRendaLessThanEqual(BigDecimal valueOf);

}
