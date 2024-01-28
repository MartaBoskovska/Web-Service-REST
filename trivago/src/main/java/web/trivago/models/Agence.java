package web.trivago.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agence {
	@Id
	@GeneratedValue
	private int id;
	private String nomAgence;
	private String nomUtilisateur;
	private String motDePasse;
	private int port; // Port du service de cette agence
	private int indexAgence;
	
	
	
	public Agence(String nomAgence, String nomUtilisateur, String motDePasse, int port, int indexAgence) {
		this.nomAgence = nomAgence;
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.port = port;
		this.indexAgence = indexAgence;
	}



	public Agence() {
		//Constructeur par défaut
	}



	public int getId() {
		return id;
	}



	public String getNomAgence() {
		return nomAgence;
	}



	public String getNomUtilisateur() {
		return nomUtilisateur;
	}



	public String getMotDePasse() {
		return motDePasse;
	}



	public int getPort() {
		return port;
	}



	public int getIndexAgence() {
		return indexAgence;
	}
	
	
	
}
