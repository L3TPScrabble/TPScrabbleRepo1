package scrabble.address.model;


import interfaces.PieceInterface;

public class Piece implements PieceInterface{
	
	private String lettre;
	private int points;
	private boolean joker;
	
	public Piece(String lettre) {
		this.lettre = lettre;
		if(lettre == ("A") || lettre == ("E") || lettre == ("I") || lettre == ("L") || lettre == ("N") || lettre == ("O") || lettre == ("R") || lettre == ("S") || lettre == ("T") || lettre == ("U"))
			this.points = 1;
		if(lettre == ("D") || lettre == ("G") || lettre == ("M"))
			this.points = 2;
		if(lettre == ("B") || lettre == ("C") || lettre == ("P"))
			this.points = 3;
		if(lettre == ("F") || lettre == ("H") || lettre == ("V"))
			this.points = 4;
		if(lettre == ("J") || lettre == ("Q"))
			this.points = 8;
		if(lettre == ("K") || lettre == ("W") || lettre == ("X") || lettre == ("Y") || lettre == ("Z"))
			this.points = 10;
		
	}
	
	public Piece(String lettre, boolean joker) {
		this.lettre = lettre;
		if(joker == true)
			this.points = 0;
	}
	
	public String getLettre(){
		return lettre;
	}
	
	public void setLettre(String nouvelleLettre){
		lettre = nouvelleLettre;
	}
	
	public int getPoints(){
		return points;
	}
	
	public void setPoints(int nouveauxPoints){
		points= nouveauxPoints;
	}
	
	public boolean getJoker(){
		return joker;
	}
	
	public void setJoker(boolean nouveauJoker){
		joker = nouveauJoker;
	}

	
	
}