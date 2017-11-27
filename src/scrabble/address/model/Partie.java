package scrabble.address.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import scrabble.address.model.Case;
import interfaces.JoueurInterface;
import interfaces.PartieInterface;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Partie implements PartieInterface{
	
	static Scanner sc = new Scanner(System.in);
	private static List<Joueur>participants;
	private static Sac sac;
	private Plateau plateau;
	
	

	public Partie() {
		
		Case c1 = new Case();
		c1.setJouable(true);
		this.participants = new ArrayList<Joueur>();
		this.sac = new Sac();
		this.plateau = new Plateau();
		this.plateau.setCase(c1,7,7);
		
	}


	public Boolean Jouer(int i,int j){
		if(this.plateau.getMatrice()[i][j].isJouable() == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void newMot() {
		
	}
	
	public void Distribution(){
		for(Joueur j : participants)
			j.newMain(sac);
	}

	
	
	public static void afficherMain(int id) {
		for(Joueur j : participants) {
			if(j.getId() == id)
			for(Piece p : j.getMain())
				System.out.print(p.getLettre() + " ");
		}
		System.out.println();
	}
	
	public Sac getSac(){
		return sac;
	}
	
	public void setSac(Sac s){
		sac = s;
	}
	
	public List<Joueur> getParticipants (){
		return participants;
	}

	public static void main(String[] args) {
		/*PartieInterface game = new Partie();
		game.newJoueur();
		game.newJoueur();
		for(Joueur j : joueurs)
			System.out.println(j.getId() + j.getPseudo());
		System.out.println(sac.getPiecesRestantes());
		tourDePioche();
		afficherMain(1);
		System.out.println(sac.getPiecesRestantes());*/

		/*	  Plateau plateau = new Plateau();
			    
			    JFrame frame = new JFrame();
			    frame.setContentPane(plateau.getTotal());
			    frame.pack();
			    frame.setVisible(true);
			  }       */
		//Fenetre fen = new Fenetre();
		
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



	@Override
	public void newJoueur() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void newPartie() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void jouerMot() {
		// TODO Auto-generated method stub
		
	}
	public Plateau getPlateau() {
		return plateau;
	}

	

}