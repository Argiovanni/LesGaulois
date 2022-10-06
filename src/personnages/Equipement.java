package personnages;

public enum Equipement {
	C("casque"), B("bouclier");
	
	private String nom;
	
	private Equipement(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
