package br.com.hexagonal.infraestructure.client;

import br.com.hexagonal.infraestructure.client.dto.ApiValidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ApiValidateClient", url = "${client.url}")
public interface ApiValidateClient {
    @GetMapping
    ApiValidateResponse validate();
}
