package br.com.hexagonal.usacase;

import br.com.hexagonal.core.domain.Wallet;

public interface FindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber(String taxNumber);
}
