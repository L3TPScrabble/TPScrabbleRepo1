import java.util.List;


public class Joueur{
	
	//Attributs 
	
	private String pseudo;
	private int numeroJoueur;
	private int score;
	private List<Piece> main;
	
	//Constructeur
	public Joueur(String pseudo, int numeroJoueur) {
		this.pseudo = pseudo;
		this.numeroJoueur = numeroJoueur;
		this.score = 0;
		this.main = null;
	}
	
	//Methods 
	
	public void Pioche(Sac S){
		Piece P;
		int nb;
		nb = (int) (Math.random() * S.getPiecesRestantes()); 
		P = S.getPioche().get(nb);
		S.getPioche().remove(nb);
		this.main.add(P);
	}
	
	public boolean mainPleine(){
		if(this.main.size() == 7 ){
			return true;
		}
		return false;
	}
	
	
}

