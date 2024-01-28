package web.trivago.models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Client {
	
	@Id
	@GeneratedValue
	private int idClient;
	private String prenom;
	private Date dateDeNaissance;
	private String motDePasse;


	public Client(String prenom, Date dateDeNaissance, String motDePasse) {
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.motDePasse = motDePasse;
	}
	
	public Client() {
		
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getIdClient() {
		return idClient;
	}

	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}


	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
}
