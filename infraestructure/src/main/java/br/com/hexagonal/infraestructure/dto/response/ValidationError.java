package br.com.hexagonal.infraestructure.dto.response;

public record ValidationError(String field, String message) {
}
