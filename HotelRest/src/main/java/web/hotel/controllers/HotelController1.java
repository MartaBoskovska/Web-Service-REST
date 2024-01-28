package web.hotel.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import web.hotel.data.ChambreData1;
import web.hotel.exceptions.InvalidDateException;
import web.hotel.exceptions.NotFoundException;
import web.hotel.models.Agence;
import web.hotel.models.Chambre;
import web.hotel.models.Client;
import web.hotel.models.Offre;
import web.hotel.models.Reservation;
import web.hotel.repositories.AgenceRepository1;
import web.hotel.repositories.ChambreRepository1;
import web.hotel.repositories.ClientRepository1;
import web.hotel.repositories.OffreRepository1;
import web.hotel.repositories.ReservationRepository1;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class HotelController1 {
	
	@Autowired
	ChambreRepository1 chambreRepo;
	@Autowired
	ReservationRepository1 resRepo;
	@Autowired
	AgenceRepository1 agenceRepo;
	@Autowired
	OffreRepository1 offreRepo;
	@Autowired
	ClientRepository1 clientRepo;
	
	private static final String uri = "hotelservice1/api";
		
	@PostMapping(uri+"/offres")
	public ArrayList<Offre> consulterDesOffres(@RequestBody Map<String,String> json) throws InvalidDateException, NotFoundException, ParseException {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateDebString = json.get("dateDebut");
		Date dateDebut = dateFormat.parse(dateDebString);
		
		String dateFinString = json.get("dateFin");
		Date dateFin = dateFormat.parse(dateFinString);
		int nbPersonnes = Integer.parseInt(json.get("nbPersonnes"));
		String idAgence = json.get("idAgence");
		String motDePasse = json.get("motDePasse");
		
		ArrayList<Offre> listeVide = new ArrayList<Offre>();
		if(!this.identification(idAgence, motDePasse)) {
			System.err.println("Erreur : l'agence : " + idAgence + " n'a pas fourni le bon mot de passe " +motDePasse + " ou n'est pas présent dans la base de données");
			return listeVide;
		};
		
		Date today = new Date();
        if(dateDebut.before(today) || dateFin.before(today)) {
        	throw new InvalidDateException();
        }
        
		ArrayList<Chambre> chambresDispo = new ArrayList<Chambre>();
		chambresDispo.addAll(chambreRepo.findAll());
		ArrayList<Chambre> chambreALL = new ArrayList<Chambre>();
		chambreALL.addAll(chambreRepo.findAll());
		for (Reservation res : resRepo.findAll()) {
			for (Chambre chambre : chambreALL) {
				if(isReserved(res,dateDebut,dateFin)) {
					if(chambre.getIdChambre()==res.getIdChambre()) chambresDispo.remove(chambre);
				}
			}
		}
		return this.getOffres(chambresDispo, nbPersonnes, dateDebut, dateFin);
	}
	
	
		
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri+"/reserver")
	public int faireUneReservation(@RequestBody Map<String, String> json) throws NotFoundException {
		//@RequestBody int id, @RequestBody String nomClient, @RequestBody String infocarte
		int id = Integer.parseInt(json.get("id"));
		String nomClient = json.get("nomClient");
		String infocarte = json.get("infocarte");
		Optional<Offre> offre = offreRepo.findById(id);
		
		Client client = new Client(nomClient);
		clientRepo.save(client);
		
		if (offre.isEmpty())
				throw new NotFoundException("Erreur: L'offre "+ id + " n'existe pas");
		int idChambre = offre.get().getChambres().get(0).getIdChambre();
		Date dateIn = offre.get().getDateDebutDispo();
		Date dateOut = offre.get().getDateFinDispo();
		try {
			Reservation res = new Reservation(client.getIdClient(), idChambre, dateIn, dateOut, null);
			resRepo.save(res);
			
			return res.getRef();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	
	
	private ArrayList<Offre> getOffres(ArrayList<Chambre> chambres, int nbLits,Date dateDebut, Date dateFin) {
		
		ArrayList<Offre> offres = new ArrayList<Offre>();
		
		for (Chambre chambre : chambres) { 
			
			if (chambre.getNbLits() >= nbLits) { 
				
				ArrayList<Chambre> chambresOffre = new ArrayList<>();
				
				chambresOffre.add(chambre);
				double prix = Offre.computePrice(chambresOffre,dateDebut,dateFin); 
				
				Offre nouvelleOffre = new Offre(chambresOffre,dateDebut,dateFin,prix);
				offreRepo.save(nouvelleOffre);
				offres.add(nouvelleOffre);
			}
		}
		return offres;
	}
	
	@PostMapping(uri+"/identification/{idAgence}")
	public boolean identification(@PathVariable String idAgence, @RequestBody String motDePasse) throws NotFoundException {
		System.err.println(idAgence);
		Agence agence = this.agenceRepo.findAll().stream().filter(o -> o.getNomAgence().equals(idAgence)).findFirst()
				.orElseThrow(() -> new NotFoundException(
					"Error: During identification could not find agence with ID " + idAgence));
		if(agence.getMotDePasse().equals(motDePasse))
			return true;
		return false;
	}
	
	
	private boolean isReserved(Reservation res, Date deb, Date fin) {
		if((deb.before(res.getDebutDate()) && (fin.before(res.getDebutDate()))) || (deb.after(res.getFinDate()) && (fin.after(res.getFinDate())))) {
			return false;
		}
		return true;
	}
	
	
	/***** POUR TESTER ******/
	@GetMapping(uri+"/agence/{id}")
	public Agence getAgenceById(@PathVariable int id) throws NotFoundException {
		return agenceRepo.findById(id) .orElseThrow(() -> new NotFoundException(
					"Error: could not find employee with ID " + id));
	}
	
	
}
