package br.com.hexagonal.infraestructure.repository;

import br.com.hexagonal.core.domain.TransactionPin;
import br.com.hexagonal.infraestructure.entity.TransactionPinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, Long> {
}
