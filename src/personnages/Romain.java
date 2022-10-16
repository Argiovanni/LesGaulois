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
	
	private int verifiePostionEquipement() {
		assert nbEquipement == 1;
		if (equipement[0] == null) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public void sEquiper(Equipement armure) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			int indice = verifiePostionEquipement();
			if (equipement[indice] == armure) {
				System.out.println("le soldat " + nom + " possède déjà un " + armure.toString() + " !");
			} else {
				equipement[2 - indice - 1] = armure;
				System.out.println("le soldat " + nom + " s'équipe avec un " + armure.toString() + "." );
				nbEquipement ++;
			}
			break;
		default: // pas d'equipement
			equipement[0] = armure;
			System.out.println("le soldat " + nom + " s'équipe avec un " + armure.toString() + "." );
			nbEquipement ++;
			break;
		}
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
		Romain minus = new Romain("Minus", 6);
		minus.parler("Ave moi !");
		minus.recevoirCoup(8);
		System.out.println("les equipement des romains sont : ");
		for (Equipement armure : Equipement.values()) {
			System.out.println("- " + armure );
		}
		minus.sEquiper(Equipement.C);
		minus.sEquiper(Equipement.C);
		minus.sEquiper(Equipement.B);
		minus.sEquiper(Equipement.B);
	}
}
