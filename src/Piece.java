import interfaces.PieceInterface;

public class Piece extends Case implements PieceInterface{
	
	protected char lettre;
	private int points;
	private boolean joker;
	
	
	public Piece(char lettre, boolean joker) {
		this.lettre = lettre;
		this.joker = joker;
		if(joker == true)
			this.points = 0;
		else {
		if(lettre == ('a') || lettre == ('e') || lettre == ('i') || lettre == ('l') || lettre == ('n') || lettre == ('o') || lettre == ('r') || lettre == ('s') || lettre == ('t') || lettre == ('u'))
			this.points = 1;
		if(lettre == ('d') || lettre == ('g') || lettre == ('m'))
			this.points = 2;
		if(lettre == ('b') || lettre == ('c') || lettre == ('p'))
			this.points = 3;
		if(lettre == ('f') || lettre == ('h') || lettre == ('v'))
			this.points = 4;
		if(lettre == ('j') || lettre == ('q'))
			this.points = 8;
		if(lettre == ('k') || lettre == ('w') || lettre == ('x') || lettre == ('y') || lettre == ('z'))
			this.points = 10;
		}
		
	}
	
}
