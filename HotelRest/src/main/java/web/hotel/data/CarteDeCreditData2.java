package web.hotel.data;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import web.hotel.models.CarteDeCredit;

import web.hotel.repositories.CarteDeCreditRepository2;



@Configuration
public class CarteDeCreditData2 {

	private Logger logger = LoggerFactory.getLogger(CarteDeCreditData2.class);
	
	@Bean
	public CommandLineRunner initDatabase4 (CarteDeCreditRepository2 repository) {
		return args -> {
			logger.info("Preloading database with " + repository.save(
					new CarteDeCredit("Marta Boshkovska","54355646547541",new Date(1674825600000L),123)));
			logger.info("Preloading database with " + repository.save(
					new CarteDeCredit("Antoine Lemaitre","41218785496978",new Date(1674825600000L),456)));
			logger.info("Preloading database with " + repository.save(
					new CarteDeCredit("Xue Yang","5241538465146486",new Date(1674825600000L),789)));
		};
	}
}