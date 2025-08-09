package br.com.hexagonal.usacase;

public interface UserAuthenticationUseCase {
    Boolean authenticate(String email, String password);
}
