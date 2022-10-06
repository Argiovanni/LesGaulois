package personnages;

public class Romain {
	private String nom;
	private int force;
	
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
	}
}
