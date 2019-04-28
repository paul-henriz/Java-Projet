package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
			Scanner lecteur = new Scanner(new File("./ListeEleves.csv"));
			while(lecteur.hasNextLine()) {
				String s = lecteur.nextLine();
				Scanner ligne = new Scanner(s);
				ligne.useDelimiter(";");
				L3.ajouterEleve(new Eleve(ligne.next(), ligne.next(), ligne.nextInt(), ligne.nextInt(), ligne.nextInt(), L3));
				ligne.close();
			}
			lecteur.close();
			System.out.printf("%5s %s\t\t %s\n", "", "Création d'élèves", "OK");

			ArrayList<Professeur> Profs = new ArrayList<>();
			lecteur = new Scanner(new File("./ListeProfesseurs.csv"));
			while(lecteur.hasNextLine()) {
				String s = lecteur.nextLine();
				Scanner ligne = new Scanner(s);
				ligne.useDelimiter(";");
				while(ligne.hasNext()) {
					Profs.add(new Professeur(ligne.next(), ligne.next()));
				}
				ligne.close();
			}
			lecteur.close();
			System.out.printf("%5s %s\t %s\n", "", "Création de professeurs", "OK");

			lecteur = new Scanner(new File("./ListeNotes.csv"));
			while(lecteur.hasNextLine()) {
				String s = lecteur.nextLine();
				Scanner ligne = new Scanner(s);
				ligne.useDelimiter(";");
				while(ligne.hasNext()) {
					int n_eleve = ligne.nextInt();
					int n_prof = ligne.nextInt();
					String matiere = ligne.next();
					float note = ligne.nextFloat();
					Eleve e = L3.rechercher(n_eleve);
					e.addEvaluation(new Evaluation(e, Profs.get(n_prof-1), matiere, note));
				}
				ligne.close();
			}
			lecteur.close();
			System.out.printf("%5s %s\t %s\n", "", "Création d'évaluations", "OK");

			System.out.println("-- Fin initialisation --");
			System.out.println();
			
			System.out.println("-- Modification de note --");
			Profs.get(0).setNote(L3, 1, 20, 0);
			Profs.get(1).setNote(L3, 1, 20, 1);
			Profs.get(2).setNote(L3, 1, 20, 2);
			System.out.println("-- Fin modification --");
			System.out.println();
			
			System.out.println("-- Sauvegarde des notes dans un fichier distinct --");
			PrintWriter sauvegarde = new PrintWriter("save_ListeNotes.csv");
			for(Eleve e : L3.getEleves()) {
				for(Evaluation n : e.getEvaluation()) {
					int i = chercherProf(Profs, n.getCorrecteur().getNom(), n.getCorrecteur().getPrenom());
					sauvegarde.println(e.getN_identifiant() + ";" + i + ";" + n.getMatiere() + ";" + n.getNote());
				}
			}
			sauvegarde.close();
			System.out.println("-- Fin sauvegarde --");
			System.out.println();
			
			System.out.println("-- Affichage d'un élève --");
			System.out.println(L3.rechercher(1));
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
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
	public static int chercherProf(ArrayList<Professeur> liste, String nom, String prenom) {
		int i = 0;
		for(Professeur p : liste) {
			if(nom == p.getNom() && prenom == p.getPrenom()) return i;
			i++;
		}
		return -1;
	}

}
