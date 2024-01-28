package web.trivago.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages= {"web.trivago.models"})
@EnableJpaRepositories(basePackages= {"web.trivago.repositories"})
@SpringBootApplication(scanBasePackages = {
		"web.trivago.data",
		"web.trivago.exceptions",
		"web.trivago.controllers",
		"web.trivago.client"
})

public class TrivagoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrivagoApplication.class, args);
	}

}
