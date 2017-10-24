import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.JoueurInterface;
import interfaces.PartieInterface;

public class Partie implements PartieInterface{
	
	static Scanner sc = new Scanner(System.in);
	private static List<Joueur>joueurs;
	private static Sac sac;
	private Plateau plateau;
	
	

	public Partie() {
		this.joueurs = new ArrayList<Joueur>();
		this.sac = new Sac();
		this.plateau = new Plateau();
	}


	public void newJoueur() {
		String nom;
		System.out.println("Rentrez votre pseudo :");
		nom = sc.nextLine();
		Joueur joueur = new Joueur(nom);
		joueurs.add(joueur);
	}
	
	public void newMot() {
		
	}
	
	public static void tourDePioche() {
		for(Joueur j : joueurs)
			j.newMain(sac);
	}
	
	
	public static void afficherMain(int id) {
		for(Joueur j : joueurs) {
			if(j.getId() == id)
			for(Piece p : j.main)
				System.out.print(p.lettre + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PartieInterface game = new Partie();
		game.newJoueur();
		game.newJoueur();
		for(JoueurInterface j : joueurs)
			System.out.println(j.getId() + j.getPseudo());
		System.out.println(sac.getPiecesRestantes());
		tourDePioche();
		afficherMain(1);
		System.out.println(sac.getPiecesRestantes());
	}
	
	

	@Override
	public void newPartie() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void jouerMot() {
		// TODO Auto-generated method stub
		
	}


	public boolean verifMot(String mot) {
		File file = new File("dico.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		try {
			while ((line = br.readLine()) != null) {
			if(mot.equals(line))
				return true;
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
