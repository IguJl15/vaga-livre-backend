package br.com.backend.vagalivre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class VagaLivreBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(VagaLivreBackendApplication.class, args);
    }
}
