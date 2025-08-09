package br.com.hexagonal.infraestructure.dto.request;

import br.com.hexagonal.core.domain.enuns.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullName, UserTypeEnum typeEnum, String pin) {
}
