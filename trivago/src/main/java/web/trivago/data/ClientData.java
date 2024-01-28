package web.trivago.data;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import web.trivago.models.Client;
import web.trivago.repositories.ClientRepository;



@Configuration
public class ClientData {

	
	private Logger logger = LoggerFactory.getLogger(ClientData.class);
	
	@Bean
	public CommandLineRunner initDatabase1 (ClientRepository repository) {
		return args -> {
			logger.info("Preloading database with " + repository.save(
					new Client("Client1", new Date(1674825600000L), "password")));	
			logger.info("Preloading database with " + repository.save(
					new Client("Client2", new Date(1674825600000L), "password")));	
			logger.info("Preloading database with " + repository.save(
					new Client("Client3", new Date(1674825600000L), "password")));	
		};
	}
}