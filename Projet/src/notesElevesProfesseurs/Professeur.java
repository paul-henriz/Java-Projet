package notesElevesProfesseurs;

public class Professeur extends Personne {

	public Professeur(String prenom, String nom) {
		super(prenom, nom);
	}

	public Eleve rechercher(Promotion p, int identifiant) {
		return p.rechercher(identifiant);
	}

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