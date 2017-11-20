package scrabble.address.model;

import java.util.ArrayList;
import java.util.List;

import interfaces.JoueurInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Joueur implements JoueurInterface{
	private String pseudo;
	private int id;
	private static int numeroJoueur = 1;
	private int score;
	private ObservableList<Piece> mainJoueur = FXCollections.observableArrayList();
	
	
	public Joueur(String pseudo) {
		this.pseudo = pseudo;
		this.score = 0;
		this.setMain(new ArrayList<Piece>());
		this.id = this.numeroJoueur;
		this.numeroJoueur ++;
	}
	
	public void newMain(Sac sac) {
		for(int i=0; i < 7; i++)
			getMain().add(sac.piocher());
	}
	
	public String getPseudo(){
		return pseudo;
	}
	
	public void setPseudo(String newPseudo){
		pseudo = newPseudo;
	}
	
	public int getNumeroJoueur(){
		return numeroJoueur;
	}
	
	public void setNumeroJoueur(int newNumeroJoueur){
		numeroJoueur = newNumeroJoueur;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int newScore)
	{
		score = newScore;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int newId){
		id = newId;
	}

	public List<Piece> getMain() {
		return mainJoueur;
	}

	public void setMain(List<Piece> main) {
		this.mainJoueur = mainJoueur;
	}
	
}