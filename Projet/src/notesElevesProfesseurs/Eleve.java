package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Eleve extends Personne implements Comparable<Eleve> {
	private int n_identifiant;
	private static int registre = 1;
	private Date date;
	private ArrayList<Evaluation> evaluation;
	private static int NB_EVALUATIONS = 10;
	private Promotion promotion;

	Eleve(String prenom, String nom) {
		super(prenom, nom);
	}

	Eleve(String prenom, String nom, int jour, int mois, int annee, Promotion prom) {
		super(prenom, nom);
		this.date = new Date(jour, mois, annee);
		this.n_identifiant = registre;
		registre++;
		evaluation = new ArrayList<Evaluation>();
		this.promotion = prom;
		this.promotion.ajouterEleve(this);
	}

	public int getN_identifiant() {
		return this.n_identifiant;
	}

	public void setN_identifiant(int n_identifiant) {
		this.n_identifiant = n_identifiant;
	}

	public void addEvaluation(Evaluation eval) {
		if (evaluation.size() < NB_EVALUATIONS)
			this.evaluation.add(eval);
		else
			System.out.println("Le nombre maximal d'évaluation est atteint.");
	}

	public ArrayList<Evaluation> getEvaluation() {
		return this.evaluation;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion p) {
		this.promotion = p;
	}

	public Date getDate() {
		return this.date;
	}

	public float moyenne() throws IllegalStateException {
		if (evaluation.size() == 0)
			throw new IllegalStateException("L'élève n'a aucune note ! Calcul de moyenne impossible.");
		float somme = 0.00f;
		for (int i = 0; i < evaluation.size(); i++) {
			somme += evaluation.get(i).getNote();
		}
		return somme / evaluation.size();
	}

	public float getMoyenne() {
		return moyenne();
	}

	public float mediane() throws IllegalStateException {
		if (evaluation.size() == 0)
			throw new IllegalStateException("L'élève n'a aucune note ! Calcul de médiane impossible.");
		float notes[] = new float[evaluation.size()];
		float mediane = 0.0f;
		for (int i = 0; i < evaluation.size(); i++) {
			notes[i] = evaluation.get(i).getNote();
		}
		Arrays.sort(notes);
		if (evaluation.size() % 2 == 0) {
			mediane = (notes[notes.length / 2] + notes[notes.length / 2 - 1]) / 2;
		} else {
			mediane = notes[notes.length / 2];
		}
		return mediane;
	}

	public float getMediane() {
		return mediane();
	}

	public Set<Professeur> getCorrecteurs() {
		Set<Professeur> correcteurs = new HashSet<Professeur>();
		for (int i = 0; i < evaluation.size(); i++) {
			correcteurs.add(evaluation.get(i).getCorrecteur());
		}
		return correcteurs;
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder();
		print.append(super.toString() + " id: " + n_identifiant + "\nnotes:");
		for (int i = 0; i < evaluation.size(); i++) {
			print.append(" " + evaluation.get(i).getMatiere() + " " + evaluation.get(i).getNote());
		}
		print.append("\nmoyenne: " + moyenne());
		print.append("\nmédiane: " + mediane());
		print.append("\ncorrecteur(s): " + getCorrecteurs().toString() + "\n");
		return print.toString();
	}

	@Override
	public int hashCode() {
		return n_identifiant;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Eleve) {
			Eleve other = (Eleve) o;
			return this.hashCode() == other.hashCode();
		}
		return false;
	}

	@Override
	public int compareTo(Eleve o) {
		if (this.getMoyenne() == o.getMoyenne())
			return 0;
		else if (this.getMoyenne() > o.getMoyenne())
			return 1;
		else
			return -1;
	}

}
