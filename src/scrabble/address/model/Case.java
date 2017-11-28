package scrabble.address.model;

import interfaces.CaseInterface;

public class Case extends Plateau implements CaseInterface{
	private int id;
	private boolean estVide;
	private Piece contenu;
	private boolean jouable;
	private int x;
	private int y;
	private boolean hasChanged;
	
	public Case() {
		this.id = 0;
		this.estVide = true;
		this.contenu = null;
		this.hasChanged = false;
		
	}
	
	
	public Case(int x , int y, int id) {
		this.id = id;
		this.estVide = true;
		this.contenu = null;
		this.x = x;
		this.y = y;
		this.hasChanged = false;
		
	}
	public Case(int id) {
		this.id = id;
		this.estVide = true;
		this.contenu = null;
		this.hasChanged = false;
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
		hasChanged = true;
	}
	
	public boolean isJouable() {
		return jouable;
	}
	public void setJouable(boolean b) {
		this.jouable = true;
	}

	
	public int getId()
	{
		return id;
	}
	
	public void setX(int X) {
		x = X;
	}
	
	public void setY(int Y) {
		y = Y;
	}
	
	public void setId(int nouvelleId)
	{
		id = nouvelleId;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	
	public int bonusCase(CaseInterface c) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean hasChanged() {
		if(this.hasChanged == true)
			return true;
		else return false;
	}
}
