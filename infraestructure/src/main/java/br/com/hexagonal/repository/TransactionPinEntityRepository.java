package br.com.hexagonal.repository;

import br.com.hexagonal.core.domain.TransactionPin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPin, Long> {
}
