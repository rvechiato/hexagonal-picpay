package br.com.hexagonal.repository;

import br.com.hexagonal.core.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntiryRepository extends JpaRepository<Transaction, Long> {
}
