package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	private String texte;
	
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
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
//	public void recevoirCoup(int forceCoup) {
//		int oldForce = force;
//		assert(force>=0);
//		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert(oldForce>force);
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("A�e");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
			parler("A�e");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force � diminuer
		assert force < oldForce;
		return equipementEjecte;
	}
	
		private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
				int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace � mon �quipement sa
					force est diminu� de ";
					for (int i = 0; i < nbEquipement;) {
						if ((equipements[i] != null &&
								equipements[i].equals(Equipement.BOUCLIER)) == true) {
							resistanceEquipement += 8;
						} else {
							System.out.println("Equipement casque");
							resistanceEquipement += 5;
						}
						i++;
					}
			texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
		
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'�quipement de " + nom.toString() + "s'envole sous la force du coup.");
				//TODO
				int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] =
						equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
		case 0: System.out.println("Le soldat " + nom + " s'�quipe avec un " + equipement);
					equipements[nbEquipement] = equipement;
					nbEquipement =  nbEquipement + 1 ;return;
		
		case 1:if(equipements[0]==equipement) {
				System.out.println("Le soldat " + nom + " poss�de d�j� un " + equipement);return;}
			if(equipements[0]!=equipement) {
				System.out.println("Le soldat " + nom + " s'�quipe avec un " + equipement);
				equipements[1] = equipement;
				nbEquipement =  nbEquipement + 1 ;
			}return;
		
		case 2:if(verifEq(equipements,equipement.BOUCLIER,equipement.CASQUE) ) {
			System.out.println("Le soldat " + nom + " est d�j� bien prot�g�");	
			return;
			}
		}
	}
	
	public static void main(String[] args) {

	}
}