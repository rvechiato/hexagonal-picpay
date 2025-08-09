package br.com.hexagonal.application.usecaseimpl;

import br.com.hexagonal.application.gateway.TaxNumberAvailableGateway;
import br.com.hexagonal.usacase.TaxNumerAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumerAvailableUseCase {

    private final TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean isTaxNumberAvailable(String taxNumber) {
        return taxNumberAvailableGateway.taxNumberAvailable(taxNumber);
    }
}
