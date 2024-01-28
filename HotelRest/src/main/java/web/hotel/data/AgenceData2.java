package web.hotel.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import web.hotel.models.Agence;
import web.hotel.repositories.AgenceRepository2;


@Configuration
public class AgenceData2 {

	
	private Logger logger = LoggerFactory.getLogger(AgenceData2.class);
	
	@Bean
	public CommandLineRunner initDatabase2 (AgenceRepository2 repository) {
		return args -> {
			logger.info("Preloading database with " + repository.save(
					new Agence("Impala", "password")));			
		};
	}
}
