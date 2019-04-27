package notesElevesProfesseurs;

/**
 * Classe définissant un professeur, classe fille de la classe Personne
 */
public class Professeur extends Personne {
	/**
	 * Constructeur à deux paramètres
	 * 
	 * @param prenom Prénom du professeur
	 * @param nom    Nom du professeur
	 */
	public Professeur(String prenom, String nom) {
		super(prenom, nom);
	}

	/**
	 * Fonction qui permet de retourner un élève à partir de son identifiant
	 * 
	 * @param p           Promotion de l'élève
	 * @param identifiant Identifiant de l'élève à rechercher
	 * @return L'élève ou le pointeur null s'il n'existe pas
	 */
	public Eleve rechercher(Promotion p, int identifiant) {
		return p.rechercher(identifiant);
	}

	/**
	 * Permet de définir la i-ème note d'un élève à partir de son identifiant
	 * 
	 * @param p           Promotion de l'élève
	 * @param identifiant Identifiant de l'élève
	 * @param valeur      Valeur de la note à définir
	 * @param indice      Indice de la note à définir
	 * @throws IllegalStateException L'identifiant ne correspond à aucun élève
	 */
	public void setNote(Promotion p, int identifiant, float valeur, int indice) throws IllegalStateException {
		Eleve corrige = rechercher(p, identifiant);
		if (corrige == null) {
			throw new IllegalStateException("L'identifiant ne correspond à aucun élève.");
		} else {
			if (indice > corrige.getEvaluation().size() - 1) {
				corrige.addEvaluation(new Evaluation(corrige, this, "N/C", valeur));
			} else {
				corrige.getEvaluation().get(indice).setNote(valeur);
			}
		}
	}
}