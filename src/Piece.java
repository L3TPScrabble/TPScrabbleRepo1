


	public class Piece extends Case{
	
	protected char lettre;
	private int points;
	
	
	public Piece(char lettre, int points) {
		this.lettre = lettre;
		this.points = points;
	}
	
	
	public char getLettre() {
		return lettre;
	}


	public void setLettre(char lettre) {
		this.lettre = lettre;
	}
	
	
}
