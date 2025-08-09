package br.com.hexagonal.application.usecaseimpl;

import br.com.hexagonal.application.gateway.ConsulteBalanceGateway;
import br.com.hexagonal.core.domain.Wallet;
import br.com.hexagonal.usacase.ConsulteBalanceUseCase;

import java.math.BigDecimal;

public class ConsulteBalanceUseCaseImpl implements ConsulteBalanceUseCase {
    private ConsulteBalanceGateway consulteBalanceGateway;

    public ConsulteBalanceUseCaseImpl(ConsulteBalanceGateway consulteBalanceGateway) {
        this.consulteBalanceGateway = consulteBalanceGateway;
    }

    @Override
    public BigDecimal consulteBalance(Wallet wallet) {
        return consulteBalanceGateway.consulte(wallet);
    }
}
