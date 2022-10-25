package personnages;
public class Musee {
	private Trophee[] trophee = new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophees( Gaulois gaulois,Equipement equipement) {
		Trophee trophees = new Trophee(gaulois,equipement);
		trophee[nbTrophee] = trophees;
		nbTrophee+=1;
	}
	
	public void extraireaInstructionsCaml() {
		String phrase = "";
		for (int i = 0; i < nbTrophee; i++){
			phrase+="     \"" + trophee[i].donnerNom() + "\", \"" + trophee[i].getEquipement() + "\"\n" ;
		}	
	String fonctOcaml =  "let musee = [ \n" + phrase + "]";
	System.out.println(fonctOcaml);
}
	    
	
	public static void main(String[] args) {
		Musee musee = new Musee();
		Gaulois asterix = new Gaulois("Asterix",8);
		musee.donnerTrophees( asterix,Equipement.CASQUE);
		musee.donnerTrophees( asterix,Equipement.CASQUE);
		musee.donnerTrophees( asterix,Equipement.CASQUE);
		musee.donnerTrophees( asterix,Equipement.CASQUE);
		musee.donnerTrophees( asterix,Equipement.CASQUE);
		musee.donnerTrophees( asterix,Equipement.CASQUE);
		musee.donnerTrophees( asterix,Equipement.CASQUE);
		musee.extraireaInstructionsCaml();
	}
}
