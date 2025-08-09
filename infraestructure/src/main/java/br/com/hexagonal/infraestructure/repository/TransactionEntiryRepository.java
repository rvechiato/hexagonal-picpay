package br.com.hexagonal.infraestructure.repository;

import br.com.hexagonal.core.domain.Transaction;
import br.com.hexagonal.infraestructure.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntiryRepository extends JpaRepository<TransactionEntity, Long> {
}
