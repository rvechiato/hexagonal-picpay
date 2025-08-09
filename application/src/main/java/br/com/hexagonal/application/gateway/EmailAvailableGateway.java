package br.com.hexagonal.application.gateway;

public interface EmailAvailableGateway {
    Boolean emailAvailable(String email);
}
