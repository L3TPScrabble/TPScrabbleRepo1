import java.util.List;
import java.util.Scanner;

import interfaces.JoueurInterface;
import interfaces.PartieInterface;

public class Partie implements PartieInterface{
	
	Scanner sc = new Scanner(System.in);
	private List<JoueurInterface>joueurs;
	private Sac sac;
	private Plateau plateau;
	
	

	public Partie() {
		super();
		this.joueurs = null;
		this.sac = new Sac();
		this.plateau = new Plateau();
	}


	public void newJoueur() {
		String nom;
		System.out.println("Rentrez votre pseudo :");
		nom = sc.nextLine();
		JoueurInterface joueur = new Joueur(nom);
		joueurs.add(joueur);
	}

	public static void main(String[] args) {
		
	
	}

}
