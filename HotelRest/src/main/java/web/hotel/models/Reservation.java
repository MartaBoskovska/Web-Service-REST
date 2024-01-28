package web.hotel.models;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue
	private int ref;
	private int idClient;
	private int idChambre;
	private Date debutDate;
	private Date finDate;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carte_de_paiment_id")
	private CarteDeCredit carteDePaiment;
	
	
	public Reservation(int idClient, int idChambre, Date debutDate, Date finDate, CarteDeCredit carte) {
	
		this.idClient = idClient;
		this.idChambre = idChambre;
		this.debutDate = debutDate;
		this.finDate = finDate;
		this.carteDePaiment = carte;
	}
	
	
	public Reservation() {
		
	}


	public int getRef() {
		return ref;
	}
	
	public int getIdClient() {
		return idClient;
	}

	
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	
	public int getIdChambre() {
		return idChambre;
	}

	
	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}

	
	public CarteDeCredit getCarteDePaiment() {
		return carteDePaiment;
	}


	public void setIdCarteDePaiment(CarteDeCredit carte) {
		this.carteDePaiment = carte;
	}


	public Date getDebutDate() {
		return debutDate;
	}

	
	public void setDebutDate(Date debutDate) {
		this.debutDate = debutDate;
	}

	
	public Date getFinDate() {
		return finDate;
	}

	
	public void setFinDate(Date finDate) {
		this.finDate = finDate;
	}


	@Override
	public int hashCode() {
		return Objects.hash(carteDePaiment, debutDate, finDate, idChambre, idClient, ref);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(carteDePaiment, other.carteDePaiment) && Objects.equals(debutDate, other.debutDate)
				&& Objects.equals(finDate, other.finDate) && idChambre == other.idChambre && idClient == other.idClient
				&& ref == other.ref;
	}
	
	

}
