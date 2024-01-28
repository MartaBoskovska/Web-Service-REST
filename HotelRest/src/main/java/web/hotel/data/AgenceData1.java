package web.hotel.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import web.hotel.models.Agence;
import web.hotel.repositories.AgenceRepository1;


@Configuration
public class AgenceData1 {

	
	private Logger logger = LoggerFactory.getLogger(AgenceData1.class);
	
	@Bean
	public CommandLineRunner initDatabase1 (AgenceRepository1 repository) {
		return args -> {
			logger.info("Preloading database with " + repository.save(
					new Agence("Impala", "password")));		
			logger.info("Preloading database with " + repository.save(
					new Agence("Meriot", "password")));		
		};
	}
}
