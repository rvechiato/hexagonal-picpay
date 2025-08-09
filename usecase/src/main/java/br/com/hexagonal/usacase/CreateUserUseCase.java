package br.com.hexagonal.usacase;

import br.com.hexagonal.core.domain.User;
import br.com.hexagonal.core.exception.TaxNumberException;
import br.com.hexagonal.core.exception.TransactionPinException;

public interface CreateUserUseCase {
    void create(User user, String pin) throws TaxNumberException, TransactionPinException;
}
