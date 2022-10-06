package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetpotion = 1;
	
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
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
					+ romain.getNom());
		romain.recevoirCoup(force / 3);
	}
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + 
				", effetpotion=" + effetpotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		effetpotion *= forcePotion;
		force *= effetpotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}
	
	public static void main(String[] args) {
	Gaulois asterix = new Gaulois("Astérix", 2);
	Romain cesar = new Romain("César", 6);
	System.out.println(asterix);
	asterix.parler("Bonjour ! ");
	asterix.frapper(cesar);
	asterix.boirePotion(4);
	asterix.frapper(cesar);
	}
	
}
