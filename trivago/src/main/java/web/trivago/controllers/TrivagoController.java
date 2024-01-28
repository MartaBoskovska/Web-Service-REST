package web.trivago.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import web.trivago.exceptions.InvalidDateException;
import web.trivago.exceptions.InvalidPasswordException;
import web.trivago.exceptions.NotFoundException;
import web.trivago.models.Agence;
import web.trivago.models.Client;
import web.trivago.models.OffreAgence;
import web.trivago.models.OffreComparateur;
import web.trivago.repositories.AgenceRepository;
import web.trivago.repositories.ClientRepository;

@RestController
public class TrivagoController {
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private AgenceRepository agenceRepo;
	@Autowired
	private RestTemplate proxy;
	
	private static final String uri = "trivago/api";
	
	@PostMapping(uri+"/identification/{idClient}")
	public boolean identification(@PathVariable int idClient, @RequestBody String motDePasse) throws NotFoundException {
		Client agence = this.clientRepo.findById(idClient).orElseThrow(() -> new NotFoundException(
					"Error: During identification could not find client with ID " + idClient));
		return agence.getMotDePasse().equals(motDePasse);
	}
	
	@PostMapping(uri+"/comparaison")
	public ArrayList<OffreComparateur> consulterDesOffres(@RequestBody Map<String,String> json) throws InvalidDateException, NotFoundException, ParseException, InvalidPasswordException{
		ArrayList<OffreComparateur> liste = new ArrayList<OffreComparateur>();
		
		Map<String, String> json1 = new HashMap<String,String>();
		int idClient = Integer.parseInt(json.get("idClient"));
		String motDePasse = json.get("motDePasse");
		
		for (Map.Entry<String, String> entry : json.entrySet()) {
	            String key = entry.getKey();
	            String value = entry.getValue();
	            json1.put(key, value);
		}
		json1.remove("idClient");
		json1.remove("motDePasse");

		//if(!this.identification(idClient, motDePasse)) {
			//throw new InvalidPasswordException("Error : Client : " + idClient + " did not enter a valid password or doesn't have an account.");
		//}
		
		for (Agence agence : agenceRepo.findAll()) {
			json1.put("idClient", "1");			
			json1.put("motDePasse", agence.getMotDePasse());
						
			OffreAgence[] offres = proxy.postForObject("http://localhost:" + agence.getPort() + "/agenceservice"+ agence.getIndexAgence() +"/api/offres", json1,OffreAgence[].class);
			
			for (int i = 0; i < offres.length; i++) {
				OffreComparateur offreAgence = new OffreComparateur(agence.getId(),offres[i].getIdHotel(), offres[i].getIdOffre(),offres[i].getChambres(), offres[i].getDateDebutDispo(), offres[i].getDateFinDispo(), offres[i].getPrix());
				liste.add(offreAgence);
			}
		}
		return liste;
	}
}
