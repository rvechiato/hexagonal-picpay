package br.com.hexagonal.repository;

import br.com.hexagonal.core.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<Wallet, Long> {
}
