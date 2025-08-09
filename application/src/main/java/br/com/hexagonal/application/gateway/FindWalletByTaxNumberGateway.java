package br.com.hexagonal.application.gateway;

import br.com.hexagonal.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {

    Wallet findByTaxNumber(String taxNumber);
}
