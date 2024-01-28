package web.trivago.data;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import web.trivago.models.Agence;
import web.trivago.repositories.AgenceRepository;

@Configuration
public class AgenceData {
	private Logger logger = LoggerFactory.getLogger(AgenceData.class);
	
	@Bean
	public CommandLineRunner initDatabase2(AgenceRepository repository) {
		return args -> {
			logger.info("Preloading database with " + repository.save(
					new Agence("Impala", "trivago", "password",8085,1)));	
			logger.info("Preloading database with " + repository.save(
					new Agence("Meriot", "trivago", "password",8085,2)));	
		};
	}
}
