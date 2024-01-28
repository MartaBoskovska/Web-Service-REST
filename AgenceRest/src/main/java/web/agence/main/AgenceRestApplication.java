package web.agence.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages= {"web.agence.models"})
@EnableJpaRepositories(basePackages= {"web.agence.repositories"})
@SpringBootApplication(scanBasePackages = {
		"web.agence.data",
		"web.agence.exceptions",
		"web.agence.controllers",
		"web.agence.client"
})
public class AgenceRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenceRestApplication.class, args);
	}

}
