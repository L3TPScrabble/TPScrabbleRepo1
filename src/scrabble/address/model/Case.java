package scrabble.address.model;

import interfaces.CaseInterface;

public class Case extends Plateau implements CaseInterface{
	private int id;
	private boolean estVide;
	private Piece contenu;
	private boolean jouable;
	
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
		return this.estVide;
	}
	
	public Piece getContenu()
	{
		return contenu;
	}
	
	public void setContenu(Piece nouveauContenu)
	{
		contenu = nouveauContenu ;
	}
	
	public boolean isJouable() {
		return jouable;
	}
	public void setJouable(Case c) {
		c.jouable = true;
	}

	
	public int getId()
	{
		return id;
	}
	
	public void setId(int nouvelleId)
	{
		id = nouvelleId;
	}
	
	public int bonusCase(CaseInterface c) {
		// TODO Auto-generated method stub
		return 0;
	}
}
