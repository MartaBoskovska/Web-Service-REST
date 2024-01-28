package web.agence.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import web.agence.models.Client;
import web.agence.models.Hotel1;
import web.agence.models.Offre;
import web.agence.models.OffreAgence;
import web.agence.repositories.ClientRepository1;
import web.agence.repositories.HotelRepository1;
import web.agence.repositories.OffreAgenceRepository1;
import web.agence.exceptions.InvalidDateException;
import web.agence.exceptions.InvalidPasswordException;
import web.agence.exceptions.NotFoundException;



@RestController
public class AgenceController1 {
	
	@Autowired
	OffreAgenceRepository1 offreRepo;
	@Autowired
	HotelRepository1 hotelRepo;
	@Autowired
	ClientRepository1 clientRepo;
	@Autowired
	RestTemplate proxy;

	private static final String uri = "agenceservice1/api";
	
		
	@PostMapping(uri+"/offres")
	public ArrayList<OffreAgence> consulterDesOffres(@RequestBody Map<String, String> json) throws InvalidDateException, NotFoundException, ParseException, InvalidPasswordException {
		
		
		ArrayList<OffreAgence> liste = new ArrayList<OffreAgence>();
		
		Map<String, String> json1 = new HashMap<String,String>();
		int idClient = Integer.parseInt(json.get("idClient"));
		String motDePasse = json.get("motDePasse");
		String ville = json.get("ville");
		
		for (Map.Entry<String, String> entry : json.entrySet()) {
	            String key = entry.getKey();
	            String value = entry.getValue();
	            json1.put(key, value);
		}
		json1.remove("idClient");
		json1.remove("motDePasse");

		if(!this.identification(idClient, motDePasse)) {
			throw new InvalidPasswordException("Error : Client : " + idClient + " did not enter a valid password or doesn't have an account.");
		}
		
		for (Hotel1 hotel : hotelRepo.findAll()) {
			if(hotel.getVille().equals(ville)) {
				json1.put("idAgence", hotel.getNomUtilisateur());			
				json1.put("motDePasse", hotel.getMotDePasse());
				
				for (Map.Entry<String, String> entry : json1.entrySet()) {
		            String key = entry.getKey();
		            String value = entry.getValue();
				}			
				Offre[] offres = proxy.postForObject("http://localhost:" + hotel.getPort() + "/hotelservice"+hotel.getIndexHotel()+"/api/offres", json1,Offre[].class);
				
				for (int i = 0; i < offres.length; i++) {
					OffreAgence offreAgence = new OffreAgence(hotel.getId(), offres[i].getId(),offres[i].getChambres(), offres[i].getDateDebutDispo(), offres[i].getDateFinDispo(), offres[i].getPrix());
					offreRepo.save(offreAgence);
					liste.add(offreAgence);
				}
			}
		}
		return liste;
	}
	
	
	@PostMapping(uri+"/identification/{idClient}")
	public boolean identification(@PathVariable int idClient, @RequestBody String motDePasse) throws NotFoundException {
		Client agence = this.clientRepo.findById(idClient).orElseThrow(() -> new NotFoundException(
					"Error: During identification could not find client with ID " + idClient));
		return agence.getMotDePasse().equals(motDePasse);
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri+"/reserver")
	public int faireUneReservation(@RequestBody Map<String, String> json) throws NotFoundException {

		int idOffre = Integer.parseInt(json.get("id"));
		OffreAgence offre = offreRepo.findAll().stream().filter(o -> o.getIdOffre() == (idOffre)).findFirst()
				.orElseThrow(() -> new NotFoundException(
						"Error: During identification could not find an offer with ID " + idOffre));
		
		int hotelId = offre.getIdHotel();
		Hotel1 hotel = hotelRepo.findById(hotelId).get();
		int refReservation =  proxy.postForObject("http://localhost:" + hotel.getPort() + "/hotelservice"+hotel.getIndexHotel()+"/api/reserver", json, Integer.class);
		return refReservation;
	}
	
	
	
}
