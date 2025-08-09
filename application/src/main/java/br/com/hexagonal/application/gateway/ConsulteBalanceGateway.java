package br.com.hexagonal.application.gateway;

import br.com.hexagonal.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsulteBalanceGateway {

    BigDecimal consulte(Wallet wallet);
}
