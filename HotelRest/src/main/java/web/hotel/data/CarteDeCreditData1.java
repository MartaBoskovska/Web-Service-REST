package web.hotel.data;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import web.hotel.models.CarteDeCredit;

import web.hotel.repositories.CarteDeCreditRepository1;



@Configuration
public class CarteDeCreditData1 {

	private Logger logger = LoggerFactory.getLogger(CarteDeCreditData1.class);
	
	@Bean
	public CommandLineRunner initDatabase3 (CarteDeCreditRepository1 repository) {
		return args -> {
			logger.info("Preloading database with " + repository.save(
					new CarteDeCredit("marta","54355646",new Date(1674825600000L),123)));
		};
	}
}