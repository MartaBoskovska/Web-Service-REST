package web.hotel.models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


enum GestionEtoiles {
  UN,
  DEUX,
  TROIS,
  QUATRE,
  CINQ
}

public class Hotel {
	
	private String nom;
	private Adresse adresse;
	private GestionEtoiles nbEtoiles;
	private ArrayList<Integer> listeChambres;
	private ArrayList<Integer> listeReservations;
	private HashMap<Integer,String> agencesPartenaires;
	
	
	public Hotel(String nom, Adresse ad, int nbEtoiles, ArrayList<Integer> chambres, ArrayList<Integer> reservations, HashMap<Integer,String> agences) {
		
		switch(nbEtoiles) {
		case 1:
			this.nbEtoiles = GestionEtoiles.UN;
		case 2:
			this.nbEtoiles = GestionEtoiles.DEUX;
		case 3:
			this.nbEtoiles = GestionEtoiles.TROIS;
		case 4:
			this.nbEtoiles = GestionEtoiles.QUATRE;
		case 5:
			this.nbEtoiles = GestionEtoiles.CINQ;
		}
		this.nom = nom;
		this.adresse = ad;
		this.listeChambres = chambres;
		this.listeReservations = reservations;
		this.agencesPartenaires = agences;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public GestionEtoiles getNbEtoiles() {
		return nbEtoiles;
	}


	public void setNbEtoiles(GestionEtoiles nbEtoiles) {
		this.nbEtoiles = nbEtoiles;
	}


	public ArrayList<Integer> getListeChambres() {
		return listeChambres;
	}


	public void setListeChambres(ArrayList<Integer> listeChambres) {
		this.listeChambres = listeChambres;
	}


	public ArrayList<Integer> getListeReservations() {
		return listeReservations;
	}


	public void setListeReservations(ArrayList<Integer> listeReservations) {
		this.listeReservations = listeReservations;
	}
	
	public HashMap<Integer, String> getAgencesPartenaires() {
		return agencesPartenaires;
	}


	public void setAgencesPartenaires(HashMap<Integer, String> agencesPartenaires) {
		this.agencesPartenaires = agencesPartenaires;
	}


	@Override
	public int hashCode() {
		return Objects.hash(adresse, agencesPartenaires, listeChambres, listeReservations, nbEtoiles, nom);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(agencesPartenaires, other.agencesPartenaires)
				&& Objects.equals(listeChambres, other.listeChambres)
				&& Objects.equals(listeReservations, other.listeReservations) && nbEtoiles == other.nbEtoiles
				&& Objects.equals(nom, other.nom);
	}


	@Override
	public String toString() {
		return "Hotel [nom=" + nom + ", adresse=" + adresse + ", nbEtoiles=" + nbEtoiles + ", listeChambres="
				+ listeChambres + ", listeReservations=" + listeReservations + ", agencesPartenaires="
				+ agencesPartenaires + "]";
	}

	
}
