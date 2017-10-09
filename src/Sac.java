import java.util.List;

public class Sac {
	private List<Piece>pioche;
	private int piecesRestantes;
	private boolean sacVide;
	
	
	public Sac() {
		this.pioche = pioche;	//définir la pioche de départ
		this.piecesRestantes = 102;
		this.sacVide = false;
		pioche.getLettre()
	}


	public List<Piece> getPioche() {
		return pioche;
	}


	public void setPioche(List<Piece> pioche) {
		this.pioche = pioche;
	}


	public int getPiecesRestantes() {
		return piecesRestantes;
	}


	public void setPiecesRestantes(int piecesRestantes) {
		this.piecesRestantes = piecesRestantes;
	}


	public boolean isSacVide() {
		return sacVide;
	}


	public void setSacVide(boolean sacVide) {
		this.sacVide = sacVide;
	}
	
	
	
}