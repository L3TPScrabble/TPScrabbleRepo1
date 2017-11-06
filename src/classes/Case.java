package classes;
import interfaces.CaseInterface;

public class Case extends Plateau implements CaseInterface{
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
		return false;
	}
	
	@Override
	public int bonusCase(CaseInterface c) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
