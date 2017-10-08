
public class Case extends Plateau{
	private int id;
	private boolean estVide;
	protected Piece contenu;
	
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
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
