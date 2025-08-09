package br.com.hexagonal.infraestructure.dto.response;

import java.util.List;

public record ErrorResponse(String code, String message, List<ValidationError> validation) {


}
