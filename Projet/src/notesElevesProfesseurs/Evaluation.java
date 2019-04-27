package notesElevesProfesseurs;

public class Evaluation {
	private String matiere;
	private float note;
	private Eleve corrige;
	private Professeur correcteur;

	public String getMatiere() {
		return this.matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public float getNote() {
		return this.note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	public Eleve getCorrige() {
		return this.corrige;
	}

	public void setCorrigé(Eleve corrige) {
		this.corrige = corrige;
	}

	public Professeur getCorrecteur() {
		return this.correcteur;
	}

	public void setCorrecteur(Professeur correcteur) {
		this.correcteur = correcteur;
	}

	// Constructeur avec 4 paramètres //
	Evaluation(Eleve corrige, Professeur correcteur, String matiere, float note) {
		this.corrige = corrige;
		this.correcteur = correcteur;
		this.matiere = matiere;
		this.note = note;

	}

	@Override
	public String toString() {
		return "((" + corrige.prenom + ", " + corrige.nom + ")" + " " + correcteur + " " + matiere + " " + note + ")";
	}
}