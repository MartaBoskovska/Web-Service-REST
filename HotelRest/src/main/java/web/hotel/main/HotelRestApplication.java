package web.hotel.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages= {"web.hotel.models"})
@EnableJpaRepositories(basePackages= {"web.hotel.repositories"})
@SpringBootApplication(scanBasePackages = {
		"web.hotel.data",
		"web.hotel.exceptions",
		"web.hotel.controllers"
})
public class HotelRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRestApplication.class, args);
	}

}
