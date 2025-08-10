package br.com.hexagonal.infraestructure.service;

import br.com.hexagonal.infraestructure.client.ApiValidateClient;
import org.springframework.stereotype.Service;

@Service
public class ApiValidateService {

    private ApiValidateClient apiValidateClient;

    public ApiValidateService(ApiValidateClient apiValidateClient) {
        this.apiValidateClient = apiValidateClient;
    }

    public Boolean validate(){
        try {
            return apiValidateClient.validate().data().authorization();
        } catch (Exception exception){
            return null;
        }
    }
}
