package com.leonardodagios.serviceproduto;

import com.leonardodagios.serviceproduto.model.Produto;
import com.leonardodagios.serviceproduto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class ServiceProdutoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProdutoApplication.class, args);
    }

}
