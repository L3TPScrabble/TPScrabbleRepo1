package scrabble.address.model;

import java.util.ArrayList;
import java.util.List;

import interfaces.SacInterface;

public class Sac implements SacInterface{
	private List<Piece>pioche;
	private int piecesRestantes;
	private boolean sacVide;

	
	public Sac() {
		this.pioche = new ArrayList<Piece>();
		newSac();
		this.piecesRestantes = 102;
		this.sacVide = false;
	}
	
	public void retirerPieces(int nombre){
		this.piecesRestantes = this.piecesRestantes - nombre;
	}
	
	
	public Piece piocher() {
		int randomId = (int)(Math.random() * pioche.size());
		Piece randomLettre = pioche.get(randomId);
		pioche.remove(randomId);
		return randomLettre;
	}
	
	/*public void newSac() {
		// TODO Auto-generated method stub
		for(int i =0; i < 9; i++)
			pioche.add(new Piece('A'));
		for(int i=0; i < 15; i++)
			pioche.add(new Piece('E'));
		for(int i=0; i < 8; i++)
			pioche.add(new Piece('I'));
		for(int i=0; i < 6; i++) {
			pioche.add(new Piece('N'));
			pioche.add(new Piece('O'));
			pioche.add(new Piece('R'));
			pioche.add(new Piece('S'));
			pioche.add(new Piece('T'));
			pioche.add(new Piece('U'));
		}
		for(int i=0; i < 5; i++)
			pioche.add(new Piece('L'));
		for(int i=0; i < 3; i++) {
			pioche.add(new Piece('D'));
			pioche.add(new Piece('M'));
		}
		for(int i=0; i < 2; i++) {
			pioche.add(new Piece('G'));
			pioche.add(new Piece('B'));
			pioche.add(new Piece('C'));
			pioche.add(new Piece('P'));
			pioche.add(new Piece('F'));
			pioche.add(new Piece('H'));
			pioche.add(new Piece('V'));
			pioche.add(new Piece(' ', true));
		}
		pioche.add(new Piece('J'));
		pioche.add(new Piece('Q'));
		pioche.add(new Piece('K'));
		pioche.add(new Piece('W'));
		pioche.add(new Piece('X'));
		pioche.add(new Piece('Y'));
		pioche.add(new Piece('Z'));
	}*/


	public List<Piece> getPioche() {
		return pioche;
	}


	public void setPioche(List<Piece> pioche) {
		this.pioche = pioche;
	}


	public int getPiecesRestantes() {
		return piecesRestantes;
	}


	public void setPiecesRestantes(int piecesRestantes) {
		this.piecesRestantes = piecesRestantes;
	}


	public boolean isSacVide() {
		return sacVide;
	}


	public void setSacVide(boolean sacVide) {
		this.sacVide = sacVide;
	}

	@Override
	public void newSac() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}