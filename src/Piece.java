import interfaces.PieceInterface;

public class Piece extends Case implements PieceInterface{
	
	protected char lettre;
	private int points;
	
	
	public Piece(char lettre, int points) {
		this.lettre = lettre;
		this.points = points;
	}
	
	
}
