package web.hotel.models;

import java.util.Objects;

public class Adresse {
	
	private String pays;
	private String ville;
	private String rue;
	private String lieuDit;
	private String positionGPS;
	
	public Adresse(String pays, String ville, String rue, String lieuDit, String positionGPS) {
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.lieuDit = lieuDit;
		this.positionGPS = positionGPS;
	}

	
	public Adresse() {
		
	}


	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getLieuDit() {
		return lieuDit;
	}

	public void setLieuDit(String lieuDit) {
		this.lieuDit = lieuDit;
	}

	public String getPositionGPS() {
		return positionGPS;
	}

	public void setPositionGPS(String positionGPS) {
		this.positionGPS = positionGPS;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lieuDit, pays, positionGPS, rue, ville);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(lieuDit, other.lieuDit) && Objects.equals(pays, other.pays)
				&& Objects.equals(positionGPS, other.positionGPS) && Objects.equals(rue, other.rue)
				&& Objects.equals(ville, other.ville);
	}
	

}
