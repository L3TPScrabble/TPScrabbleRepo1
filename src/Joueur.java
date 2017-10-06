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
	
	
}
