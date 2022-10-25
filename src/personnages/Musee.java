package personnages;

public class Musee {
	private Equipement[] trophee = new Equipement[200];
	private int nbTrophee;
	
	public void donnerTrophees(Trophee gaulois,Equipement equipement) {
		trophee[nbTrophee] = gaulois.getEquipement();
		nbTrophee+=1;
	}
	
	public void faireUneDonation(String nomMusee) {
		if(nbTrophee > 0) {
			System.out.println("Le gaulois" +  + ": au " + nomMusee + "tous mes trophees :");
			for(int i = 0; i < nbTrophee; i++) {
				System.out.println("-" + trophee[i]);
			}
		}
	}
}
