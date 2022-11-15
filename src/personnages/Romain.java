package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
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

	
	// TODO si 1 equi forcement indice 0
	private int verifiePostionEquipement() {
		assert nbEquipement == 1;
		if (equipements[0] == null) {
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
			if (equipements[indice] == armure) {
				System.out.println("le soldat " + nom + " possède déjà un " + armure.toString() + " !");
			} else {
				equipements[1 - indice] = armure;
				System.out.println("le soldat " + nom + " s'équipe avec un " + armure.toString() + "." );
				nbEquipement ++;
			}
			break;
		default: // pas d'equipement
			equipements[0] = armure;
			System.out.println("le soldat " + nom + " s'équipe avec un " + armure.toString() + "." );
			nbEquipement ++;
			break;
		}
	}
	
	// TP3
	
	public int getResistance() {
		int resistance = 0;
		if (nbEquipement != 0) {
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.B)) == true) {
					resistance += 8;
				} else {
					resistance += 5;	
		}}}
		return resistance;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = getResistance();
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de "+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup <= 0) {
			return 0;
		}
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// precondition
		
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
		if (forceCoup == 0) {
			parler("AHAHAH, même pas mal !!!");
		} else if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force à diminuer
		assert force <= oldForce;
		return equipementEjecte;
	}
	
	
	// fin tp3


	public static void main(String[] args) {
		System.out.println("les equipement des romains sont : ");
		for (Equipement armure : Equipement.values()) {
			System.out.println("- " + armure );
		}
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.C);
		minus.sEquiper(Equipement.C);
		minus.sEquiper(Equipement.B);
		minus.sEquiper(Equipement.B);
		minus.parler("Ave moi !");
		minus.recevoirCoup(8);
	}
}
