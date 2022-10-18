package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		equipements = new Equipement[2];
		this.nom = nom;
		this.force = force;
		assert(force>=0);
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		assert(force>=0);
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert(force+forceCoup>force);
	}
	
	public boolean verifEq(Equipement[] equipements, Equipement equipement1, Equipement equipement2) {
		boolean succes=false;
		if (equipements[0]==equipement1 && equipements[1]==equipement2 ) {
			return succes=true;}
		if (equipements[1]==equipement1 && equipements[0]==equipement2 ) {
			return succes=true;}
		else {
			return succes;
		}	
		
	}
	
	public void sEquiper(Equipement equipement){
		switch(nbEquipement) {
		case 0: System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement);
					equipements[nbEquipement] = equipement;
					nbEquipement =  nbEquipement + 1 ;return;
		
		case 1:if(equipements[0]==equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement);return;}
			if(equipements[0]!=equipement) {
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement);
				equipements[1] = equipement;
				nbEquipement =  nbEquipement + 1 ;
			}return;
		
		case 2:if(verifEq(equipements,equipement.BOUCLIER,equipement.CASQUE) ) {
			System.out.println("Le soldat " + nom + " est déjà bien protégé");	
			return;
			}
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);

	}
}