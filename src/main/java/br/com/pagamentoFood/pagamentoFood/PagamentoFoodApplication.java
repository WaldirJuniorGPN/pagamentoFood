package br.com.pagamentoFood.pagamentoFood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class PagamentoFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagamentoFoodApplication.class, args);
	}

}
