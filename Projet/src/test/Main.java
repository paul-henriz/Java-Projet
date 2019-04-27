package test;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("-- Initialisation --");
			Promotion L3 = new Promotion("L3");
			System.out.printf("%5s %s\t %s\n", "", "Création d'une promotion", "OK");

			Eleve Jean = new Eleve("Jean", "Tille", 8, 9, 1997, L3);
			Eleve Paul = new Eleve("Paul", "Dupont", 11, 2, 2003, L3);
			Eleve Claire = new Eleve("Claire", "Fine", 4, 3, 2001, L3);
			System.out.printf("%5s %s\t\t %s\n", "", "Création d'élèves", "OK");

			Professeur Soleil = new Professeur("Soleil", "Tournesol");
			Professeur Michel = new Professeur("Super", "Michel");
			Professeur Javel = new Professeur("Aude", "Javel");
			System.out.printf("%5s %s\t %s\n", "", "Création de professeurs", "OK");

			Jean.addEvaluation(new Evaluation(Jean, Soleil, "Mathématiques", 13.0f));
			Jean.addEvaluation(new Evaluation(Jean, Javel, "Informatique", 8.0f));
			Jean.addEvaluation(new Evaluation(Jean, Michel, "Physique", 12.0f));
			Paul.addEvaluation(new Evaluation(Paul, Soleil, "Mathématiques", 16.0f));
			Paul.addEvaluation(new Evaluation(Paul, Javel, "Informatique", 15.0f));
			Paul.addEvaluation(new Evaluation(Paul, Michel, "Physique", 18.0f));
			Claire.addEvaluation(new Evaluation(Paul, Soleil, "Mathématiques", 10.0f));
			Claire.addEvaluation(new Evaluation(Paul, Javel, "Informatique", 20.0f));
			Claire.addEvaluation(new Evaluation(Paul, Michel, "Physique", 11.0f));
			System.out.printf("%5s %s\t %s\n", "", "Création d'évaluations", "OK");

			
		} catch (IllegalStateException e) {
			System.err.println(e.getMessage());
		}
	}

}
