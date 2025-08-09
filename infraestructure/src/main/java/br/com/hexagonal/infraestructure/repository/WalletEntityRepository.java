package br.com.hexagonal.infraestructure.repository;

import br.com.hexagonal.core.domain.Wallet;
import br.com.hexagonal.infraestructure.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
}
