package classes;
import interfaces.PieceInterface;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Piece extends Case implements PieceInterface{
	
	private final StringProperty lettreI = new SimpleStringProperty(this, "lettre", null);
	protected char lettre;
	private int points;
	private boolean joker;
	
	
	public Piece(char lettre) {
		this.lettre = lettre;
		if(lettre == ('A') || lettre == ('E') || lettre == ('I') || lettre == ('L') || lettre == ('N') || lettre == ('O') || lettre == ('R') || lettre == ('S') || lettre == ('T') || lettre == ('U'))
			this.points = 1;
		if(lettre == ('D') || lettre == ('G') || lettre == ('M'))
			this.points = 2;
		if(lettre == ('B') || lettre == ('C') || lettre == ('P'))
			this.points = 3;
		if(lettre == ('F') || lettre == ('H') || lettre == ('V'))
			this.points = 4;
		if(lettre == ('J') || lettre == ('Q'))
			this.points = 8;
		if(lettre == ('K') || lettre == ('W') || lettre == ('X') || lettre == ('Y') || lettre == ('Z'))
			this.points = 10;
		
	}
	
	public Piece (){
	
	}
	public Piece(char lettre, boolean joker) {
		this.lettre = lettre;
		if(joker == true)
			this.points = 0;
	}

	  // Getter.
	  public final String getLettreI() {
	    return lettreI.get();
	  }

	  // Setter.
	  public final void setLettreI(final String value) {
	    lettreI.set(value);
	  }

	  // Accès à la propriété.
	  public final StringProperty lettreIProperty() {
	    return lettreI;
  }
	  public String toString() {
		  return getLettreI();
		}
	
}
