package web.agence.models;

import java.io.Serializable;
import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Chambre implements Serializable{
	
	
	@Id
	@GeneratedValue
	private int idChambre;
	private double prixNuit;
	private int nbLits;
	private String imgURL;
	

	
	public Chambre() {
		
	}
	
	public Chambre(double prix, int nbLits, String imgURL) {
		this.prixNuit = prix;
		this.nbLits = nbLits;
		this.imgURL = imgURL;
	}
	

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public int getIdChambre() {
		return idChambre;
	}

	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}

	public void setNbLits(int nbLits) {
		this.nbLits = nbLits;
	}

	public double getPrixNuit() {
		return this.prixNuit;
	}
	
	public void setPrixNuit(double prix) {
		this.prixNuit = prix;
	}
	
	public int getNbLits() {
		return this.nbLits;
	}

	@Override
	public String toString() {
		return "Chambre [NumChambre= " + idChambre + ", Lits= " + nbLits + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idChambre, nbLits, prixNuit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chambre other = (Chambre) obj;
		return idChambre == other.idChambre && nbLits == other.nbLits
				&& Double.doubleToLongBits(prixNuit) == Double.doubleToLongBits(other.prixNuit);
	}
}
