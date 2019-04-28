package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe définissant un élève, classe fille de la classe Personne
 */
public class Eleve extends Personne implements Comparable<Eleve> {
	/**
	 * Entier représentant l'identifiant de l'élève
	 */
	private int n_identifiant;

	/**
	 * Registre permettant d'assurer une logique de l'attribution des identifiants
	 */
	private static int registre = 1;

	/**
	 * Date de naissance
	 */
	private Date date;

	/**
	 * Ensemble des évaluations de l'élève
	 */
	private ArrayList<Evaluation> evaluation;

	/**
	 * Limite du nombre d'évaluations possibles
	 */
	private static int NB_EVALUATIONS = 10;

	/**
	 * Promotion de l'élève
	 */
	private Promotion promotion;

	/**
	 * Constructeur à deux paramètres
	 * 
	 * @param prenom Prénom de l'élève
	 * @param nom    Nom de l'élève
	 */
	Eleve(String prenom, String nom) {
		super(prenom, nom);
		this.n_identifiant = registre;
		registre++;
		evaluation = new ArrayList<Evaluation>();
	}

	/**
	 * Constructeur à six paramètres (complet)
	 * 
	 * @param prenom Prénom de l'élève
	 * @param nom    Nom de l'élève
	 * @param jour   Jour de naissance
	 * @param mois   Mois de naissance
	 * @param annee  Année de naissance
	 * @param prom   Promotion de l'élève
	 */
	public Eleve(String prenom, String nom, int jour, int mois, int annee, Promotion prom) {
		super(prenom, nom);
		this.date = new Date(jour, mois, annee);
		this.n_identifiant = registre;
		registre++;
		evaluation = new ArrayList<Evaluation>();
		this.promotion = prom;
	}

	/**
	 * Retourne l'identifiant de l'élève
	 * 
	 * @return Identifiant de l'élève
	 */
	public int getN_identifiant() {
		return this.n_identifiant;
	}

	/**
	 * Définit l'identifiant de l'élève
	 * 
	 * @param n_identifiant Identifiant de l'élève
	 */
	public void setN_identifiant(int n_identifiant) {
		this.n_identifiant = n_identifiant;
	}

	/**
	 * Ajoute une évaluation si la limite n'est pas dépasser
	 * 
	 * @param eval Evaluation à ajouter
	 */
	public void addEvaluation(Evaluation eval) {
		if (evaluation.size() < NB_EVALUATIONS)
			this.evaluation.add(eval);
		else
			System.out.println("Le nombre maximal d'évaluation est atteint.");
	}

	/**
	 * Retourne la liste des évaluations
	 * 
	 * @return Liste des évaluations
	 */
	public ArrayList<Evaluation> getEvaluation() {
		return this.evaluation;
	}

	/**
	 * Retourne la promotion de l'élève
	 * 
	 * @return Promotion de l'élève
	 */
	public Promotion getPromotion() {
		return this.promotion;
	}

	/**
	 * Définit la promotion de l'élève
	 * 
	 * @param p Promotion de l'élève
	 */
	public void setPromotion(Promotion p) {
		this.promotion = p;
	}

	/**
	 * Retourne la date de naissance de l'élève
	 * 
	 * @return Date de naissance de l'élève
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Calcul la moyenne si l'élève a des évaluations, sinon capture l'exception
	 * 
	 * @return Moyenne des notes de l'élève
	 * @throws IllegalStateException L'élève n'a aucune note
	 */
	private float moyenne() throws IllegalStateException {
		if (evaluation.size() == 0)
			throw new IllegalStateException("L'élève n'a aucune note ! Calcul de moyenne impossible.");
		float somme = 0.00f;
		for (int i = 0; i < evaluation.size(); i++) {
			somme += evaluation.get(i).getNote();
		}
		return somme / evaluation.size();
	}

	/**
	 * Retourne la moyenne
	 * 
	 * @return Moyenne de l'élève
	 */
	public float getMoyenne() {
		return moyenne();
	}

	/**
	 * Calcul la médiane si l'élève a des évaluations, sinon capture l'exception
	 * 
	 * @return Médiane des notes de l'élève
	 * @throws IllegalStateException L'élève n'a aucune note
	 */
	private float mediane() throws IllegalStateException {
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

	/**
	 * Retourne la médiane
	 * 
	 * @return Médiane de l'élève
	 */
	public float getMediane() {
		return mediane();
	}

	/**
	 * Retourne dans un Set les différents correcteurs (professeurs) de l'élève
	 * 
	 * @return Professeurs qui ont corrigé l'élève
	 */
	public Set<Professeur> getCorrecteurs() {
		Set<Professeur> correcteurs = new HashSet<Professeur>();
		for (int i = 0; i < evaluation.size(); i++) {
			correcteurs.add(evaluation.get(i).getCorrecteur());
		}
		return correcteurs;
	}

	/**
	 * Surcharge pour l'affichage d'un élève et de ses notes
	 */
	@Override
	public String toString() {
		StringBuilder print = new StringBuilder();
		print.append(super.toString() + " id: " + n_identifiant + "\nnotes:");
		for (int i = 0; i < evaluation.size(); i++) {
			print.append(" " + evaluation.get(i).getMatiere() + " " + evaluation.get(i).getNote());
		}
		print.append("\nmoyenne: " + getMoyenne());
		print.append("\nmédiane: " + getMediane());
		print.append("\ncorrecteur(s): " + getCorrecteurs().toString() + "\n");
		return print.toString();
	}

	/**
	 * Surcharge pour modifier la signature des objets élèves
	 */
	@Override
	public int hashCode() {
		return n_identifiant;
	}

	/**
	 * Surcharge pour définir l'égalité de deux élèves s'ils ont le même identifiant
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Eleve) {
			Eleve other = (Eleve) o;
			return this.hashCode() == other.hashCode();
		}
		return false;
	}

	/**
	 * Surcharge de la comparaison entre deux élèves
	 */
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
