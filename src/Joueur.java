import java.util.ArrayList;
import java.util.List;

import interfaces.JoueurInterface;

public class Joueur implements JoueurInterface{
	private String pseudo;
	private int id;
	private static int numeroJoueur = 1;
	private int score;
	List<Piece> main;
	
	
	public Joueur(String pseudo) {
		this.pseudo = pseudo;
		this.score = 0;
		this.main = new ArrayList<Piece>();
		this.id = this.numeroJoueur;
		this.numeroJoueur ++;
	}
	
	public void newMain(Sac sac) {
		for(int i=0; i < 7; i++)
			main.add(sac.piocher());
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}

	

	
	
	
}
