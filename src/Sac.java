import java.util.List;

public class Sac{
	private List<Piece>pioche;
	private int piecesRestantes;
	private boolean sacVide;
	
	
	public Sac() {
		this.pioche = pioche;	//définir la pioche de départ
		this.piecesRestantes = 102;
		this.sacVide = false;
	}
	


	public int getPiecesRestantes() {
		return piecesRestantes;
	}



	public List<Piece> getPioche() {
		return pioche;
	}



	public void retirerPieces(int nombre){
		this.piecesRestantes = this.piecesRestantes - nombre;
}


	
}