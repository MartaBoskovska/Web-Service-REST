package web.agence.models;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Offre {

	@Id
	@GeneratedValue
	private int id;
	private ArrayList<Chambre> chambres;
	private Date dateDebutDispo;
	private Date dateFinDispo;
	private double prix;
	
	public Offre(ArrayList<Chambre> chambres, Date dateDebutDispo, Date dateFinDispo, double prix) {
		
		this.chambres = chambres;
		this.dateDebutDispo = dateDebutDispo;
		this.dateFinDispo = dateFinDispo;
		this.prix = prix;
	}
	
	
	public Offre() {
		
	}

	public static double computePrice(ArrayList<Chambre> chambres, Date in,Date out) {
		double price = 0;
		for (Chambre chambre : chambres) {
			price += chambre.getPrixNuit();
		}
		long duration = TimeUnit.DAYS.convert(out.getTime()-in.getTime(), TimeUnit.MILLISECONDS);
		return price*duration;
	}

	public int getId() {
		return id;	
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
	public int hashCode() {
		return Objects.hash(chambres, dateDebutDispo, dateFinDispo, id, prix);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offre other = (Offre) obj;
		return Objects.equals(chambres, other.chambres) && Objects.equals(dateDebutDispo, other.dateDebutDispo)
				&& Objects.equals(dateFinDispo, other.dateFinDispo) && id == other.id
				&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix);
	}
	
}
