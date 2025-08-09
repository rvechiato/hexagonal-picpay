package br.com.hexagonal.usacase;

import br.com.hexagonal.core.domain.TaxNumber;

public interface TaxNumerAvailableUseCase {
    Boolean isTaxNumberAvailable(String taxNumber);
}
