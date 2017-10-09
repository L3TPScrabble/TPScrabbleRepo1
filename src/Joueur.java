import java.util.List;

public class Joueur {
	private String pseudo;
	private int numeroJoueur;
	private int score;
	private List<Piece> main;
	
	
	public Joueur(String pseudo, int numeroJoueur) {
		this.pseudo = pseudo;
		this.numeroJoueur = numeroJoueur;
		this.score = 0;
		this.main = null;
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
	
}
