package web.agence.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import web.agence.models.Hotel2;
import web.agence.repositories.HotelRepository2;


@Configuration
public class HotelData2 {

	
	private Logger logger = LoggerFactory.getLogger(HotelData2.class);
	
	@Bean
	public CommandLineRunner initDatabase4 (HotelRepository2 repository) {
		return args -> {
			logger.info("Preloading database with " + repository.save(
					new Hotel2("Hotel1", 8080,1, "Impala","password", "Paris")));	
		};
	}
}