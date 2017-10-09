import java.util.List;

import interfaces.SacInterface;

public class Sac implements SacInterface{
	private List<Piece>pioche;
	private int piecesRestantes;
	private boolean sacVide;
	
	
	public Sac() {
		this.pioche = pioche;	//définir la pioche de départ
		this.piecesRestantes = 102;
		this.sacVide = false;
	}
	
	public void retirerPieces(int nombre){
		this.piecesRestantes = this.piecesRestantes - nombre;
}
	
}