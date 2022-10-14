package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private String [] villageois;
	public Village(String nom ,int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new String[nbVillageoisMaximum];
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois.getNom();
		nbVillageois =+1;
	}
	public void trouverHabitant(int numVillageois) {
		System.out.println(villageois[numVillageois]);
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
		Gaulois gaulois = village.trouverHabitant(30);
	}

}
