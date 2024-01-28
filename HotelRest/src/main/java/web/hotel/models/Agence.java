package web.hotel.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agence {
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idAgence, motDePasse, nomAgence);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agence other = (Agence) obj;
		return idAgence == other.idAgence && Objects.equals(motDePasse, other.motDePasse)
				&& Objects.equals(nomAgence, other.nomAgence);
	}

	@Id
	@GeneratedValue
	private int idAgence;
	private String nomAgence;
	private String motDePasse;
	
	
	public Agence(String nomAgence,String motDePasse) {
		this.nomAgence = nomAgence;
		this.motDePasse = motDePasse;
	}

	public Agence() {
		
	}
	
	public int getIdAgence() {
		return idAgence;
	}


	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}


	public String getNomAgence() {
		return nomAgence;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

}
