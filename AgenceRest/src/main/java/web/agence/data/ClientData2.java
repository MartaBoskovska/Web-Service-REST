package web.agence.data;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import web.agence.models.Client;
import web.agence.repositories.ClientRepository2;



@Configuration
public class ClientData2 {

	
	private Logger logger = LoggerFactory.getLogger(ClientData2.class);
	
	@Bean
	public CommandLineRunner initDatabase2 (ClientRepository2 repository) {
		return args -> {
			logger.info("Preloading database with " + repository.save(
					new Client("Client21", new Date(1674825600000L), "password")));	
			logger.info("Preloading database with " + repository.save(
					new Client("Client22", new Date(1674825600000L), "password")));	
			logger.info("Preloading database with " + repository.save(
					new Client("Client23", new Date(1674825600000L), "password")));	
		};
	}
}