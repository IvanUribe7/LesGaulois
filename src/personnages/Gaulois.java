package personnages;
public class Gaulois {
	private String nom;
	private int effetPotion = 7;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
//				+ romain.getNom());
//		romain.recevoirCoup((force / 3)*effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesGagne = romain.recevoirCoup((force / 3) * effetPotion);
				for (int i = 0; tropheesGagne != null && i < tropheesGagne.length; i++,nbTrophees++) {
					this.trophees[nbTrophees] = tropheesGagne[i];
				}
			}

	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		System.out.println(prendreParole() + " Merci Druide, je sens que ma force est 3 fois décuplée");
	}
	public static void main(String[] args) {
		Gaulois asterix= new Gaulois("Asterix",8);
		System.out.println(asterix);
		System.out.println(asterix.effetPotion);

}

}