package personnages;
import java.util.Random;
import personnages.Gaulois;
public class Druide {
	private String nom;
	private int effetPotionMin=5;
	private int effetPotionMax=10;
	private int forcePotion;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � " + effetPotionMax + ".");
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	public void preparerPotion() {
		Random random = new Random();
		forcePotion = random.nextInt(effetPotionMax-effetPotionMin)+effetPotionMin;
		if(forcePotion>7){
			System.out.println(prendreParole() + "� J'ai pr�par� une super potion de force  " + forcePotion + " �");
		}
		else{
			System.out.println(prendreParole() + "� Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force " + forcePotion + " �");
		}
	
	}
	

	public void booster(Gaulois gaulois) {
		if(gaulois.getNom() == "Obelix") {
			System.out.println(prendreParole() + "� Non, Ob�lix !... Tu n'auras pas de potion magique !�");
			gaulois.parler("Par B�l�nos, ce n'est pas juste !");
		}
		else {
			gaulois.parler("Merci Druide, je sens que ma force est 6 fois d�cupl�e");
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.preparerPotion();
	}
	
}
