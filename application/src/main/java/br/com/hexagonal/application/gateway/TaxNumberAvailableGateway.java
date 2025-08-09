package br.com.hexagonal.application.gateway;

public interface TaxNumberAvailableGateway {
    Boolean taxNumberAvailable(String taxNumber);
}
