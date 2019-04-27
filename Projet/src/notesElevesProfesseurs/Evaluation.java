package notesElevesProfesseurs;

/**
 * Classe définissiant une évaluation
 */
public class Evaluation {
	/**
	 * Chaine de caractères représentant la matière
	 */
	private String matiere;

	/**
	 * Nombre flottant représentant la note obtenue par l'élève
	 */
	private float note;

	/**
	 * Elève ayant été noté
	 */
	private Eleve corrige;

	/**
	 * Professeur ayant corrigé
	 */
	private Professeur correcteur;

	/**
	 * Retourne la matière de l'évaluation
	 * 
	 * @return Chaine de caractère représentant la matière
	 */
	public String getMatiere() {
		return this.matiere;
	}

	/**
	 * Définit la matière de l'évaluation
	 * 
	 * @param matiere Chaine de caractère représentant la matière
	 */
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	/**
	 * Retourne la note de l'évaluation
	 * 
	 * @return Note de l'élève
	 */
	public float getNote() {
		return this.note;
	}

	/**
	 * Définit la note de l'évaluation
	 * 
	 * @param note Note de l'élève
	 */
	public void setNote(float note) {
		this.note = note;
	}

	/**
	 * Retourne l'élève qui a été corrigé
	 * 
	 * @return Eleve corrigé
	 */
	public Eleve getCorrige() {
		return this.corrige;
	}

	/**
	 * Définit l'élève qui a été corrigé
	 * 
	 * @param corrige Eleve corrigé
	 */
	public void setCorrigé(Eleve corrige) {
		this.corrige = corrige;
	}

	/**
	 * Retourne le correcteur
	 * 
	 * @return Professeur correcteur
	 */
	public Professeur getCorrecteur() {
		return this.correcteur;
	}

	/**
	 * Définit le correcteur
	 * 
	 * @param correcteur Professeur correcteur
	 */
	public void setCorrecteur(Professeur correcteur) {
		this.correcteur = correcteur;
	}

	/**
	 * Constructeur à quatre paramètres
	 * 
	 * @param corrige    L'élève qui a été corrigé
	 * @param correcteur Le professeur qui a corrigé
	 * @param matiere    La matière de l'évaluation
	 * @param note       La note obtenue par l'élève
	 */
	public Evaluation(Eleve corrige, Professeur correcteur, String matiere, float note) {
		this.corrige = corrige;
		this.correcteur = correcteur;
		this.matiere = matiere;
		this.note = note;

	}

	/**
	 * Surcharge pour l'affichage d'une évaluation
	 */
	@Override
	public String toString() {
		return "((" + corrige.prenom + ", " + corrige.nom + ")" + " " + correcteur + " " + matiere + " " + note + ")";
	}
}