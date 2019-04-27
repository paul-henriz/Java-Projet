package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Classe définissant la promotion (collection d'élève)
 */
public class Promotion {
	/**
	 * Nom de la promotion
	 */
	private String nom;
	
	/**
	 * Collection d'élèves constituant la promotion
	 */
	private ArrayList<Eleve> promo;

	/**
	 * Constructeur à 1 paramètre
	 * @param nomPromo Nom de la promotion
	 */
	public Promotion(String nomPromo) {
		this.nom = nomPromo;
		promo = new ArrayList<Eleve>();
	}

	/**
	 * Retourne le nom de la promotion
	 * @return Nom de la promotion
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Définit le nom de la promotion
	 * @param nom Nom de la promotion
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Retourne la liste d'élèves constituant la promotion
	 * @return Liste des élèves
	 */
	public ArrayList<Eleve> getEleves() {
		return this.promo;
	}

	/**
	 * Ajoute un élève à la promotion
	 * @param etudiant Eleve à ajouter
	 */
	public void ajouterEleve(Eleve etudiant) {
		promo.add(etudiant);
		etudiant.setPromotion(this);
	}

	/**
	 * Recherche un élève à partir de son identifiant
	 * @param identifiant Identifiant de l'élève
	 * @return Elève si trouvé, le pointeur null sinon
	 */
	public Eleve rechercher(int identifiant) {
		for (Eleve e : promo) {
			if (e.getN_identifiant() == identifiant)
				return e;
		}
		return null;
	}

	/**
	 * Tri la collection par ordre croissant en regardant la moyenne
	 */
	public void triCroissantMoyenne() {
		Collections.sort(promo);
	}

	/**
	 * Tri la collection par ordre croissant en regardant la médiane
	 */
	public void triCroissantMediane() {
		Collections.sort(promo, new MedianeComparator());
	}

	/**
	 * Tri la collection par ordre décroissant en regardant la moyenne
	 */
	public void triDecroissantMoyenne() {
		triCroissantMoyenne();
		Collections.reverse(promo);
	}

	/**
	 * Tri la collection par ordre décroissant en regardant la médiane
	 */
	public void triDecroissantMediane() {
		triCroissantMediane();
		Collections.reverse(promo);
	}

	/**
	 * Surcharge pour l'affichage d'une promotion
	 */
	@Override
	public String toString() {
		return "Promotion " + nom + "\n" + promo;
	}
}
