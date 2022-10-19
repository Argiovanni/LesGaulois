package personnages;

public class Gaulois {
	private String nom;
	private int force; 
	private int nbTrophees = 0;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + 
				", effetpotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}
	
	//TP3
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophy = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophy != null && i < trophy.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophy[i];
		}
	}
	
	public void faireUneDonnation (Musee musee) {
		if (nbTrophees > 0) {
			parler("Je donne au musee tous mes trophees :");
			do {
				musee.donnerTrophee(this, trophees[nbTrophees -1]);
				System.out.println("- "+ trophees[nbTrophees -1].toString());
				trophees[nbTrophees -1] = null;  // 'supprime' trophee
				nbTrophees --;
				
			} while (nbTrophees > 0);
		}
		
	}
	
	public static void main(String[] args) {
	Gaulois asterix = new Gaulois("Astérix", 2);
	Romain cesar = new Romain("César", 6);
	System.out.println(asterix);
	asterix.parler("Bonjour ! ");
	asterix.frapper(cesar);
	asterix.boirePotion(4);
	asterix.frapper(cesar);
	System.out.println(asterix.trophees[2]);
	}
	
}
