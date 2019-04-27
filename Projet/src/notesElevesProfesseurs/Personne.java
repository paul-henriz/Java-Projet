package notesElevesProfesseurs;

/**
 * Question 1: L'héritage est le concept de la programmation orientée objet le
 * plus approprié dans ce cas.
 */
public class Personne {
	protected String prenom;
	protected String nom;

	Personne(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "(" + prenom + ", " + nom + ")";
	}
}
