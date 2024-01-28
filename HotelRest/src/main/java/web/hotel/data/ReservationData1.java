package web.hotel.data;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import web.hotel.models.CarteDeCredit;
import web.hotel.models.Reservation;
import web.hotel.repositories.ReservationRepository1;


@Configuration
public class ReservationData1 {

	private Logger logger = LoggerFactory.getLogger(ReservationData1.class);
	
	@Bean
	public CommandLineRunner initDatabase7 (ReservationRepository1 repository) {
		return args -> {
			logger.info("Preloading database with " + repository.save(
						new Reservation(1, 1 , new Date(1674374400000L), new Date(1674825600000L), new CarteDeCredit("marta","54355646",new Date(1674825600000L),123))));		
		};
	}
}
