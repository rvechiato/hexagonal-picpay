package br.com.hexagonal.usacase;

import br.com.hexagonal.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsulteBalanceUseCase {
    BigDecimal consulteBalance(Wallet wallet);
}
