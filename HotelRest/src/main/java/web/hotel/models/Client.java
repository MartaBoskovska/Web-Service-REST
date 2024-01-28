package web.hotel.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Client {
	
	@Override
	public int hashCode() {
		return Objects.hash(idClient, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return idClient == other.idClient && Objects.equals(nom, other.nom);
	}


	@Id
	@GeneratedValue
	private int idClient;
	private String nom;



	public Client(String nom) {
		this.nom = nom;
		
	}
	
	
	public Client() {
		
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String prenom) {
		this.nom = prenom;
	}
}
