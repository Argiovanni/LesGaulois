package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;
	
	private boolean forceEstPositif() {
		boolean forcePositif = true;
		if (force < 0) {
			forcePositif = false;
		}
		return forcePositif;
	}
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert forceEstPositif();
	}
	
	public String getNom() {
		return nom;
	}
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	// TODO: faire methode s'equiper avec equipement en param
	
	public void recevoirCoup(int forceCoup) {
		assert forceEstPositif();
		int variant = force;
		force = getForce() - forceCoup;
		assert forceADiminuee(variant);
		if (getForce() > 0) {
			parler("Aïe");
		} else {
			force = 0;
			parler("J'abandonne...");
		}
	}
	
	private boolean forceADiminuee(int oldValue) {
		if (force < oldValue) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Romain cesar = new Romain("César", 6);
		cesar.parler("Ave moi !");
		cesar.recevoirCoup(8);
		System.out.println("les equipement des romains sont : ");
		for (Equipement armure : Equipement.values()) {
			System.out.println("- " + armure );
		}
	}
}
