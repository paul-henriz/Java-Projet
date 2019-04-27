package test;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

public class TestNormal {

	public static void main(String[] args) {
		try {
			System.out.println("## Scénario normal ##");
			System.out.println("### Début d'éxecution ###");
			System.out.println();
			
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

			System.out.println("-- Fin initialisation --");
			System.out.println();
			
			System.out.println("-- Affichage d'un élève --");
			System.out.println(Jean);
			System.out.println("-- Fin affichage élève --");
			System.out.println();
			
			System.out.println("-- Affichage d'une promotion --");
			System.out.println(L3);
			System.out.println("-- Fin affichage promotion --");
			System.out.println();
			
			System.out.println("-- Recherche d'un élève --");
			System.out.println(L3.rechercher(2));
			System.out.println("-- Fin recherche --");
			System.out.println();
			
			System.out.println("-- Tests tris --");
			L3.triCroissantMoyenne();
			System.out.printf("%5s %s\t\t %s\n", "", "Tri croissant par moyenne", "OK");
			L3.triCroissantMediane();
			System.out.printf("%5s %s\t\t %s\n", "", "Tri croissant par médiane", "OK");
			L3.triDecroissantMoyenne();
			System.out.printf("%5s %s\t %s\n", "", "Tri décroissant par moyenne", "OK");
			L3.triDecroissantMediane();
			System.out.printf("%5s %s\t %s\n", "", "Tri décroissant par médiane", "OK");
			System.out.println("--Fin tests tris --");
			System.out.println();
			
			System.out.println("-- Affichage tri croissant moyenne --");
			L3.triCroissantMoyenne();
			System.out.println(L3);
			System.out.println("--Fin tri croissant moyenne --");
			System.out.println();
			System.out.println("-- Affichage tri croissant médiane --");
			L3.triCroissantMediane();
			System.out.println(L3);
			System.out.println("--Fin tri croissant médiane --");
			System.out.println();
			System.out.println("-- Affichage tri décroissant moyenne --");
			L3.triDecroissantMoyenne();
			System.out.println(L3);
			System.out.println("--Fin tri décroissant moyenne --");
			System.out.println();
			System.out.println("-- Affichage tri décroissant médiane --");
			L3.triDecroissantMediane();
			System.out.println(L3);
			System.out.println("--Fin tri décroissant médiane --");
			System.out.println();
			
			System.out.println();
			System.out.println("### Fin d'éxecution ###");
			
		} catch (IllegalStateException e) {
			System.err.println(e.getMessage());
		}
	}

}
