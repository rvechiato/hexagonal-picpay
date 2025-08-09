package br.com.hexagonal.application.gateway;

import br.com.hexagonal.core.domain.TransactionPin;
import br.com.hexagonal.core.domain.User;
import br.com.hexagonal.core.domain.Wallet;

public interface CreateUserGateway {
    Boolean create(User user, Wallet wallet);
}
