package web.agence.models;

public class Agence {
	
	private int idAgence;
	private String nomAgence;
	private float reduction; // Pourcentage de réduction
	
	
	public Agence(int id,String nomAgence,float reduction) {
		this.idAgence = id;
		this.nomAgence = nomAgence;
		this.reduction = reduction;
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

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public float getReduction() {
		return reduction;
	}

	public void setReduction(float reduction) {
		this.reduction = reduction;
	}
	
	

}
