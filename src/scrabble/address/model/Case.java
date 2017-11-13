package scrabble.address.model;

import interfaces.CaseInterface;

public class Case extends Plateau implements CaseInterface{
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
		// TODO Auto-generated method stub
		return false;
	}
	
	public Piece getContenu()
	{
		return contenu;
	}
	
	public void setContenu(Piece nouveauContenu)
	{
		contenu = nouveauContenu ;
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