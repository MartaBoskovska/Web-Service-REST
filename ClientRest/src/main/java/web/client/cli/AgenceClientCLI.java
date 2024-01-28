package web.client.cli;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import web.client.models.OffreAgence;
import web.client.models.OffreComparateur;



public class AgenceClientCLI {
	
	
	public static RestTemplate proxy = new RestTemplate();
	public static String URI_AGENCE = "http://localhost:8085/agenceservice";

	public static void main(String[] args) {
		
		AgenceClientCLI client = new AgenceClientCLI();
		Scanner in = new Scanner(System.in);
		String rep = "";
		int id = 0;
		String motPasse = "";
				
		System.out.println("Choisissez votre agence ?");
		System.out.println("1. Agence Impala");
		System.out.println("2. Agence MerionTravel");
		System.out.println("3. Trivago");
		
		int idAgence = in.nextInt();
		
		URI_AGENCE += idAgence + "/api/";
		while(idAgence > 4 || idAgence < 1)
		{
			System.out.println("Numéro d'agence inconnu veuillez réessayer");
			System.out.println("Choisissez votre agence ?");
			System.out.println("1. Agence Impala");
			System.out.println("2. Agence MerionTravel");
			System.out.println("3. Trivago");
			
			
			idAgence = in.nextInt();
		}
		
		System.out.println("Veuillez vous connecter :");
		id = in.nextInt();
		motPasse = in.next();
		
		try {
			boolean connected = proxy.postForObject(URI_AGENCE + "identification/"+id, motPasse , boolean.class);
		}catch(Exception e) {
			System.out.println("Vous avez saisi un identifiant ou un mot de passe erroné, veuillez réessayer.\n");
			id = in.nextInt();
			motPasse = in.next();
		}
		

		System.out.println("Connexion reussite.\n");
		
		if (idAgence == 3) {
			trivagoHandler(in, id, motPasse);
		}
		else {
		
		rep = "";
		while(!rep.equals("q")) {
			System.out.println("Que voulez vous faire ?\n");
			System.out.println("1. Afficher des offres\n"
					+ "2. Faire une réservation\n"
					+ "<q> pour quitter");
			rep = in.next();
			if (rep.equals("q")) {
				return;
			}
			else if (rep.equals("1")) {
				client.consulterOffresAgence(in, id, motPasse);
			}
			else if (rep.equals("2")) {
				client.effectuerReservationAgence(in);
			}
			else {
				System.out.println("Erreur option inconnue ou non implémentée");
			}
		}
		}
	}
	
	private static void consulterOffresAgence(Scanner in, int id, String motPasse) {
		try {
			System.out.println("Veuillez indiquer le nombre de personnes :");
			int nbPersonnes = in.nextInt();
			System.out.println("Veuillez indiquer la ville désirée parmis Paris ou Moscou:");
			String ville = in.next();
			System.out.println("Veuillez indiquer une date d'arrivée au format jj/mm/aaaa :");
			String dateInString = in.next();
			try {
				
				System.out.println("Veuillez indiquer une date de départ au format jj/mm/aaaa :");
				String dateOutString = in.next();
				
				System.out.println("Veuillez indiquer le prix maximum :");
				double prix = in.nextDouble();
				
				
				Map<String,String> json = new HashMap<String,String>();
				json.put("dateDebut", dateInString);
				json.put("dateFin", dateOutString);
				json.put("nbPersonnes", nbPersonnes + "");
				json.put("ville", ville);
				json.put("idClient", id + "");
				json.put("motDePasse", motPasse);
				
				
				System.out.println("Liste des offres pour votre recherche :");
				
				OffreAgence[] offres =  proxy.postForObject(URI_AGENCE + "offres", json,OffreAgence[].class);
				
				for(int i = 0; i < offres.length; i++) {
					System.out.println(offres[i].toString() + "\n");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	private static void effectuerReservationAgence(Scanner in) {
		try {
			System.out.println("Veuillez indiquer l'id de l'offre que vous avez choisi :");
			int idOffre = in.nextInt();
			System.out.println("Veuillez indiquer votre nom pour la réservation : ");
			String nomClient = in.next();
			int idRes;
			
			Map<String,String> json = new HashMap<String,String>();
			json.put("id", idOffre +"");
			json.put("nomClient", nomClient);
			json.put("infocarte", "222example");
			
			idRes =  proxy.postForObject(URI_AGENCE + "reserver", json, Integer.class);

			if (idRes >= 0) {
				System.out.println("Votre réservation numéro : " + idRes + " a bien été réalisée");
			}
			else {
				System.out.println("Une erreur s'est produite l'offre demandée n'existe pas");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void trivagoHandler(Scanner in,int id,String motPasse) {
		try {
			System.out.println("Veuillez indiquer le nombre de personnes :");
			int nbPersonnes = in.nextInt();
			System.out.println("Veuillez indiquer la ville désirée parmis Paris ou Moscou:");
			String ville = in.next();
			System.out.println("Veuillez indiquer une date d'arrivée au format jj/mm/aaaa :");
			String dateInString = in.next();
			try {
				
				System.out.println("Veuillez indiquer une date de départ au format jj/mm/aaaa :");
				String dateOutString = in.next();
				
				System.out.println("Veuillez indiquer le prix maximum :");
				double prix = in.nextDouble();
				
				
				Map<String,String> json = new HashMap<String,String>();
				json.put("dateDebut", dateInString);
				json.put("dateFin", dateOutString);
				json.put("nbPersonnes", nbPersonnes + "");
				json.put("ville", ville);
				json.put("idClient", id + "");
				json.put("motDePasse", motPasse);
				
				
				System.out.println("Liste des offres pour votre recherche :");
				
				OffreComparateur[] offres =  proxy.postForObject("http://localhost:8100/trivago/api/comparaison", json,OffreComparateur[].class);
				
				for(int i = 0; i < offres.length; i++) {
					System.out.println(offres[i].toString() + "\n");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
