package br.com.hexagonal.application.gateway;

public interface UserAuthenticationGateway {
    Boolean authenticate(String username, String password);
}
