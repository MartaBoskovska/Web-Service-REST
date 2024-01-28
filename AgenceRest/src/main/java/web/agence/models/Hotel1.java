package web.agence.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hotel1 {
	
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String nomUtilisateur;
	private int port; // Port du service de cet hotel
	private int indexHotel;
	private String motDePasse;
	private String ville;
	
	public Hotel1(String name, int port,int indexHotel, String nomUtilisateur, String motDePasse,String ville) {
		this.nom = name;
		this.port = port;
		this.indexHotel = indexHotel;
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.ville = ville;
	}
	
	
	public Hotel1() {
		//Constructeur par defaut
	}
	
	public int getIndexHotel() {
		return indexHotel;
	}


	public void setIndexHotel(int indexHotel) {
		this.indexHotel = indexHotel;
	}


	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPort(int port) {
		this.port = port;
	}

	
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getId()
	{
		return this.id;
	}
	
	public int getPort() {
		return this.port;
	}
}
