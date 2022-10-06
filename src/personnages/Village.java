package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois habitant) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = habitant;
			nbVillageois ++;
		}
	}
	
	public Gaulois trouverHabitant(int code) {
		return villageois[code];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+ chef.getNom() +" vivent les legendaires gaulois :");
		int i = 0;
		do {
			System.out.println("- " + villageois[i].getNom());
			i ++;
		} while (villageois[i] != null);
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30); --> Index 30 out of bounds for length 30
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois); --> null :: pas de gaulois dans le village a l'indice 1
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
