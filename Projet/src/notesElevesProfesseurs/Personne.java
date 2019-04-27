package notesElevesProfesseurs;

/**
 * Classe regroupant les attributs communs à l'élève et au professeur
 * (utilisation de l'héritage)
 */
public class Personne {
	/**
	 * Prénom de la personne
	 */
	protected String prenom;

	/**
	 * Nom de la personne
	 */
	protected String nom;

	/**
	 * Constructeur à deux paramètres
	 * 
	 * @param prenom Prénom de la personne
	 * @param nom    Nom de la personne
	 */
	Personne(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	/**
	 * Retourne le prénom sous forme de chaine de caractères
	 * 
	 * @return Prénom de la personne
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Définit le prénom à partir d'une chaine de caractères
	 * 
	 * @param prenom Prénom de la personne
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Retourne le nom sous forme de chaine de caractères
	 * 
	 * @return Nom de la personne
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Définit le nom à partir d'une chaine de caractères
	 * 
	 * @param nom Nom de la personne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Surcharge pour l'affichage d'une personne
	 */
	@Override
	public String toString() {
		return "(" + prenom + ", " + nom + ")";
	}
}
