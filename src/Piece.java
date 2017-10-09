
public class Piece {
	
	private char lettre;
	private int points;
	
	
	public Piece(char lettre, int points) {
		this.lettre = lettre;
		this.points = points;
	}
	
	public char getLettre(){
		return lettre;
	}
	
	public void setLettre(char nouvelleLettre){
		lettre = nouvelleLettre;
	}
	
	public int getPoints(){
		return points;
	}
	
	public void setPoints(int nouveauxPoints){
		points= nouveauxPoints;
	}

	
	
}
