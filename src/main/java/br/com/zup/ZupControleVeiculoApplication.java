package br.com.zup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ZupControleVeiculoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZupControleVeiculoApplication.class, args);
	}

}
