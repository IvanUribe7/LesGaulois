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
	
	public Equipement[] getTrophees() {
		return trophees;
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
	
	public void faireUneDonation(Musee musee) {
		String phrase = "";
		while(nbTrophees > 0) {
			nbTrophees-=1;
			musee.donnerTrophees(this , trophees[nbTrophees]);
			phrase += "-" + trophees[nbTrophees] + "\n";
			trophees[nbTrophees]=null;
		}
		parler("Je donne au musee tous mes trophees : \n" + phrase);
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
		Musee musee = new Musee();
		asterix.faireUneDonation(musee);

}

}