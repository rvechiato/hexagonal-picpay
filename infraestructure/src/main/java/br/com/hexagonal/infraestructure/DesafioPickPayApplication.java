package br.com.hexagonal.infraestructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioPickPayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesafioPickPayApplication.class, args);
    }
}
