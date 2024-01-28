package web.hotel.models;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class CarteDeCredit {

	@Id
	@GeneratedValue
	private int idCarte;
	private String nomPrenom;
	private String numero;
	private Date dateExpiration;
	private int codeSecret;
	
	
	public CarteDeCredit(String nomPrenom, String numero, Date dateExpiration, int codeSecret) {
		
		this.nomPrenom = nomPrenom;
		this.numero = numero;
		this.dateExpiration = dateExpiration;
		this.codeSecret = codeSecret;
	}

	

	public CarteDeCredit() {
	
	}



	public int getIdCarte() {
		return idCarte;
	}


	public void setIdCarte(int idCarte) {
		this.idCarte = idCarte;
	}


	public String getNomPrenom() {
		return nomPrenom;
	}


	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Date getDateExpiration() {
		return dateExpiration;
	}


	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}


	public int getCodeSecret() {
		return codeSecret;
	}


	public void setCodeSecret(int codeSecret) {
		this.codeSecret = codeSecret;
	}
	
	
	
}
