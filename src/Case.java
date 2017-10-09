import interfaces.CaseInterface;

<<<<<<< HEAD
public class Case{
=======
public class Case extends Plateau implements CaseInterface{
>>>>>>> 19ef56c347864d8f5cf863fb55d4afb90be69dac
	private int id;
	private boolean estVide;
	private Piece contenu;
	
	public Case() {
		this.id = 0;
		this.estVide = true;
		this.contenu = null;
	}
	public Case(int id) {
		this.id = id;
		this.estVide = true;
		this.contenu = null;
	}


	public boolean estVide() {
		return false;
	}
	
	public Piece getContenu() {
		return contenu;
	}
	public void setContenu(Piece contenu) {
		this.contenu = contenu;
	}
}
