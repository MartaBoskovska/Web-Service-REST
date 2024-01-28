package web.agence.data;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import web.agence.models.Client;
import web.agence.repositories.ClientRepository1;



@Configuration
public class ClientData1 {

	
	private Logger logger = LoggerFactory.getLogger(ClientData1.class);
	
	@Bean
	public CommandLineRunner initDatabase1 (ClientRepository1 repository) {
		return args -> {
			logger.info("Preloading database with " + repository.save(
					new Client("Client11", new Date(1674825600000L), "password")));	
			logger.info("Preloading database with " + repository.save(
					new Client("Client12", new Date(1674825600000L), "password")));	
			logger.info("Preloading database with " + repository.save(
					new Client("Client13", new Date(1674825600000L), "password")));	
		};
	}
}