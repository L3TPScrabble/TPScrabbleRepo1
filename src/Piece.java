import interfaces.PieceInterface;

<<<<<<< HEAD
public class Piece{

	private char lettre;
=======
public class Piece extends Case implements PieceInterface{
	
	protected char lettre;
>>>>>>> 19ef56c347864d8f5cf863fb55d4afb90be69dac
	private int points;
	
	
	public Piece(char lettre, int points) {
		this.lettre = lettre;
		this.points = points;
	}
<<<<<<< HEAD
	
	
	public char getLettre() {
		return lettre;
	}


	public void setLettre(char lettre) {
		this.lettre = lettre;
	}
=======
>>>>>>> 19ef56c347864d8f5cf863fb55d4afb90be69dac
	
	
}
