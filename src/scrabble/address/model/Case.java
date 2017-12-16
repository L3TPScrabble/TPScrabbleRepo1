package scrabble.address.model;

import interfaces.CaseInterface;

public class Case extends Plateau implements CaseInterface{
	private int id;
	private boolean estVide;
	private Piece contenu;
	private boolean jouable;
	private boolean pleine;
	private int x;
	private int y;
	
	public Case() {
		this.id = 0;
		this.estVide = true;
		this.contenu = null;
		
	}
	public Case(int x , int y) {
		this.id = 0;
		this.estVide = true;
		this.contenu = null;
		this.x = x;
		this.y = y;
		
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
	
	/**
	 * @return the pleine
	 */
	public boolean isPleine() {
		return pleine;
	}
	/**
	 * @param pleine the pleine to set
	 */
	public void setPleine(boolean pleine) {
		this.pleine = pleine;
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
	
	public void setId(int nouvelleId)
	{
		id = nouvelleId;
	}
	
	public int bonusCase(CaseInterface c) {
		// TODO Auto-generated method stub
		return 0;
	}
}
