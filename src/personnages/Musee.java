package personnages;

public class Musee {
	private Trophee[] tableau = new Trophee[200];
	private int nbTrophee = 0;
	
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		Trophee gift = new Trophee(gaulois, equipement);
		tableau[nbTrophee] = gift;
		nbTrophee ++;
	}
	
	
	public String extraireInstructionsCaml() {
		String instruction = "let musee = [\n";
		for (int i = 0; i < nbTrophee ; i++) {
			Gaulois gaulois = tableau[i].getGaulois();
			Equipement equip = tableau[i].getEquipement();
			instruction += "\t" + '"' + gaulois.getNom() + '"' + " , " + '"' + equip.toString() + '"' + " ; \n";
		}
		Gaulois gaulois = tableau[nbTrophee -1].getGaulois();
		Equipement equip = tableau[nbTrophee -1].getEquipement();
		instruction +=  "\t" +'"' + gaulois.getNom() +  '"' + " , " +  '"' + equip.toString() + '"' + " \n]";
		nbTrophee = 0;
	return instruction;
	}
	
	public static void main(String[] args) {
		Musee museum = new Musee();
		Gaulois asterix = new Gaulois("Asterix", 8);
		museum.donnerTrophee(asterix,Equipement.B);
		System.out.println("bouclier");
		museum.donnerTrophee(asterix,Equipement.C);
		System.out.println("casque");
		System.out.println(museum.extraireInstructionsCaml());
	}
}