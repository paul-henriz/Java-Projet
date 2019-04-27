package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Collections;

public class Promotion {
	private String nom;
	private ArrayList<Eleve> promo;

	public Promotion(String nomPromo) {
		this.nom = nomPromo;
		promo = new ArrayList<Eleve>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Eleve> getEleves() {
		return this.promo;
	}

	public void ajouterEleve(Eleve etudiant) {
		promo.add(etudiant);
		etudiant.setPromotion(this);
	}

	public Eleve rechercher(int identifiant) {
		for (Eleve e : promo) {
			if (e.getN_identifiant() == identifiant)
				return e;
		}
		return null;
	}

	public void triCroissantMoyenne() {
		Collections.sort(promo);
	}

	public void triCroissantMediane() {
		Collections.sort(promo, new MedianeComparator());
	}

	public void triDecroissantMoyenne() {
		triCroissantMoyenne();
		Collections.reverse(promo);
	}

	public void triDecroissantMediane() {
		triCroissantMediane();
		Collections.reverse(promo);
	}
}
