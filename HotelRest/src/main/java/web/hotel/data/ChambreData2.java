package web.hotel.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import web.hotel.models.Chambre;
import web.hotel.repositories.ChambreRepository2;


@Configuration
public class ChambreData2 {

	
	private Logger logger = LoggerFactory.getLogger(ChambreData2.class);
	
	@Bean
	public CommandLineRunner initDatabase6 (ChambreRepository2 repository) {
		return args -> {
			logger.info("Preloading database with " + repository.save(
					new Chambre(20,4, "https://thumbs.dreamstime.com/b/luxury-hotel-room-king-size-bed-15166031.jpg")));		
			logger.info("Preloading database with " + repository.save(
					new Chambre(25,4, "https://thumbs.dreamstime.com/b/hotel-room-beautiful-orange-sofa-included-43642330.jpg")));	
			logger.info("Preloading database with " + repository.save(
					new Chambre(15,2, "https://thumbs.dreamstime.com/b/hotel-room-beautiful-orange-sofa-included-43642330.jpg")));	
			logger.info("Preloading database with " + repository.save(
					new Chambre(18,3, "https://thumbs.dreamstime.com/b/luxury-hotel-room-king-size-bed-15166031.jpg")));	
		};
	}
}
