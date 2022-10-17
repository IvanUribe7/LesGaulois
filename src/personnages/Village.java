package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois;
	private Gaulois[] villageois;
	public Village(String nom ,int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois= nbVillageois+1;
	}
	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}
	
	public void afficherVillageois(Chef Chef) {
		int i;
		System.out.println("Dans le village de chef " + Chef.getNom() + " vivent les légendaires gaulois : " + "\n");
		for(i = 0; i<nbVillageois;i++) {
			System.out.println("- " + trouverHabitant(i).getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",5);
		//*Gaulois gaulois = village.trouverHabitant(30); le programme tente d'accéder à un tableau avec un indice invalide.//*
		//*On cherche a l'indice 30 alors que la liste va de 0 a 29 //*
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		Gaulois asterix = new Gaulois("Asterix",8);
		village.ajouterHabitant(asterix);
		Gaulois obelix = new Gaulois("Obelix",8);
		village.ajouterHabitant(obelix);
		village.afficherVillageois(abraracourcix);
		//*Gaulois gaulois = village.trouverHabitant(1);//*
		//*System.out.println(gaulois); Il renvoit "null" car le gaulois Asterix a été garder dans l indice 0 de la liste et l indice 1 est vide//*
	}

}
