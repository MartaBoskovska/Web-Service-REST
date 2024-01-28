package web.agence.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import web.agence.models.Hotel1;
import web.agence.repositories.HotelRepository1;


@Configuration
public class HotelData1 {

	
	private Logger logger = LoggerFactory.getLogger(HotelData1.class);
	
	@Bean
	public CommandLineRunner initDatabase3 (HotelRepository1 repository) {
		return args -> {
			logger.info("Preloading database with " + repository.save(
					new Hotel1("Hotel1", 8080,1, "Impala","password", "Paris")));	
			logger.info("Preloading database with " + repository.save(
					new Hotel1("Hotel2", 8080,2, "Impala", "password", "Moscou")));	
		};
	}
}