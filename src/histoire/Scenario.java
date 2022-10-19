package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;
//TODO: finir debug + faire classe musee pour transition Ocaml
public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Romain minus = new Romain("Minus", 6);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.sEquiper(Equipement.B);
		minus.sEquiper(Equipement.C);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0);
		asterix.frapper(minus);
	}
}
