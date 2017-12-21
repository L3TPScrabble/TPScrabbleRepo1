package scrabble.address.model;

import interfaces.CaseInterface;

public class Case extends Plateau implements CaseInterface{
	private boolean estVide;
	private Piece contenu;
	private boolean jouable;
	private boolean hasChanged;
	private boolean pleine;
	private boolean isCyan;
	private boolean isBlue;
	private boolean isPink;
	private boolean isRed;
	private boolean caseDroite;
	private boolean caseBas;
	private boolean caseGauche;
	private boolean caseHaut;
	private boolean caseJouableTour;
	private int x;
	private int y;
	
	public Case() {
		this.estVide = true;
		this.contenu = null;
		this.hasChanged = false;
		
	}
	
	public Case(int x , int y) {
		this.estVide = true;
		this.contenu = null;
		this.hasChanged = false;
		this.x = x;
		this.y = y;
		//Case rouge
		if((x == 0 && ( (y == 0) || (y == 7) || (y == 14) ) )
		   || (x == 7 && ( (y == 0) || (y == 14) ) )
		   || (x == 14 && ( (y == 0) || (y == 7) || (y == 14) ) )
		   )
			isRed = true;
		//Case rose
		else if((x == 1 && (y == 1 || y == 13)) || (x == 2 && (y == 2 || y == 12)) 
        		|| (x == 3 && (y == 3 || y == 11)) || (x == 4 && (y == 4 || y == 10))
        		|| (x == 10 && (y == 4 || y == 10)) || (y == 11 && (y == 3 || y == 11))
        		|| (x == 12 && (y == 2 || y == 12)) || (x == 13 && (y == 1 || y == 13))
        		|| (x == 7 && y == 7))
			isPink = true;
		//Case Blue
		 else if((x == 1 && (y == 5 || y == 9)) 
         		|| (x == 5 && (y == 1 || y == 5 || y == 9 || y == 13))
         		|| (x == 9 && (y == 1 || y == 5 || y == 9 || y == 13))
         		|| (x == 13 && (y == 5 || y == 9)))
			isBlue = true;
		 else if(((x == 0 || x == 14) && (y == 3 || y == 11)) 
         		|| ((x == 2 || x == 12) && (y == 6 || y == 8))
         		|| ((x == 3 || x == 11) && (y == 0 || y == 7 || y == 14))
         		|| ((x == 6 || x == 8) && (y == 2 || y == 6 || y == 8 || y == 12))
         		|| (x == 7 && (y == 3 || y == 11)))
			 isCyan = true;
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
	
	public boolean HasChanged(){
		return hasChanged;
	}
	
	public void setHasChanged(boolean _hasChanged){
		this.hasChanged = _hasChanged;
	}
	
	public boolean isJouable() {
		return jouable;
	}
	
	public void setJouable(boolean b) {
		this.jouable = true;
	}
	
	public boolean isPleine() {
		return pleine;
	}
	
	public void setPleine(boolean _pleine){
		pleine = _pleine;
	}
	
	public boolean isCyan(){
		return isCyan;
	}
	
	public void setIsCyan(boolean _cyan){
		isCyan = _cyan;
	}
	
	public boolean isBlue(){
		return isBlue;
	}
	
	public void setIsBlue(boolean _blue){
		isBlue = _blue;
	}
	
	public boolean isRed(){
		return isRed;
	}
	
	public void setIsRed(boolean _red){
		isRed = _red;
	}
	
	public boolean isPink(){
		return isPink;
	}
	
	public void setIsPink(boolean _pink){
		isPink = _pink;
	}
	
	public void whichColor(){
		if(isPink)
			System.out.println("Cette case est rose ! ");
		else if (isRed)
			System.out.println("Cette case est rose ! ");
		else if (isCyan)
			System.out.println("Cette case est cyan ! ");
		else if (isBlue)
			System.out.println("Cette case est bleu ! ");
		else
			System.out.println("Cette case est verte ! ");
	}
	
	public int bonusCase(CaseInterface c) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * @param caseDroite the caseDroite to set
	 */
	public void setCaseDroite(boolean caseDroite) {
		this.caseDroite = caseDroite;
	}

	/**
	 * @param caseDessus the caseDessus to set
	 */
	public void setCaseBas(boolean caseBas) {
		this.caseBas = caseBas;
	}

	/**
	 * @return the caseJouableTour
	 */
	public boolean isCaseJouableTour() {
		return caseJouableTour;
	}

	/**
	 * @param caseJouableTour the caseJouableTour to set
	 */
	public void setCaseJouableTour(boolean caseJouableTour) {
		this.caseJouableTour = caseJouableTour;
	}

	/**
	 * @return the caseGauche
	 */
}
