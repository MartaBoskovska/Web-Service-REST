package web.client.models;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class OffreAgence {
	
	@Id
	@GeneratedValue
	private int id;
	private int idHotel;
	private int idOffre;
	private ArrayList<Chambre> chambres;
	private Date dateDebutDispo;
	private Date dateFinDispo;
	private double prix;
	
	
	public OffreAgence(int idHotel,int idOffre, ArrayList<Chambre> chambres, Date dateDebutDispo, Date dateFinDispo, double prix) {
		
		this.idHotel = idHotel; 
		this.idOffre = idOffre; 
		this.chambres = chambres;
		this.dateDebutDispo = dateDebutDispo;
		this.dateFinDispo = dateFinDispo;
		this.prix = prix;
	}
	
	public OffreAgence() {
		//Constructeur par defaut
	}
	
	public int getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}


	public int getIdOffre() {
		return idOffre;
	}


	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(ArrayList<Chambre> chambres) {
		this.chambres = chambres;
	}

	
	public Date getDateDebutDispo() {
		return dateDebutDispo;
	}

	public void setDateDebutDispo(Date dateDebutDispo) {
		this.dateDebutDispo = dateDebutDispo;
	}

	public Date getDateFinDispo() {
		return dateFinDispo;
	}

	public void setDateFinDispo(Date dateFinDispo) {
		this.dateFinDispo = dateFinDispo;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Identifiant de l'offre : " + idOffre + "\n" + ", Description de logement : " + chambres + "\n"
				+ ", Date de debut de disponibilite :" + dateDebutDispo + "\n" + ", Date de fin de disponibilite" + dateFinDispo + "\n" + ", Prix total : " + prix + "$\n";
	}
	
}
