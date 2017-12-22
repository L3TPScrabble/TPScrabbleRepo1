package scrabble.address.model;

import java.util.Random;

import interfaces.CaseInterface;
import interfaces.PlateauInterface;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Plateau implements PlateauInterface{


	private Case[][] matrice;
	private int taille;
	
	
	public Plateau() {
		this.taille = 15;
		this.matrice = new Case[taille][taille];
		
	}


	public Boolean estPlein() {
		for(int i=0; i<=14 ; i++)
			for(int j=0; j<=14; j++)
				if(matrice[i][j].estVide())
					return false;			
		return true;
	}
	
	
	//Calcul du score à partir des coordonnées de la première lettre (i1,j1) et de la derniere lettre (i2,j2)
	public int score(int i1, int j1, int i2, int j2){
		System.out.println("Deuxieme methode");
		int total = 0;
		boolean motDouble = false;
		boolean motTriple = false;
		
		//mot de gauche à droite
		if(i1 == i2){ 
			for(int j = j1; j<=j2; j++){
				
				matrice[i1][j].whichColor();
				
				//si la case est rose alors le mot compte double
				if(matrice[i1][j].isPink()){
					motDouble = true;
					total = total + matrice[i1][j].getContenu().getPoints() ;
				}
				
				//Si la case est rouge alors le mot compte triple
				else if(matrice[i1][j].isRed()){
					motTriple = true;
					total = total + matrice[i1][j].getContenu().getPoints();
				}
				
				//Si la case est bleu alors les points de la lettre valent triple
				else if(matrice[i1][j].isBlue())
					total = total + matrice[i1][j].getContenu().getPoints() * 3;
				
				//Si la case est cyan alors les points de la lettre valent double
				else if(matrice[i1][j].isCyan())
					total = total + matrice[i1][j].getContenu().getPoints() * 2;
				
				//Sinon on ajoute uniquement les points de la lettre
				else
					total = total + matrice[i1][j].getContenu().getPoints();
			}
		}
		
		//mot de haut en bas
		else if(j1 == j2){
			for(int i = i1; i<=i2; i++){
				
				matrice[i][j1].whichColor();
				if(matrice[i][j1].isPink()){
					motDouble = true;
					total = total + matrice[i][j1].getContenu().getPoints() ;
				}
				else if(matrice[i][j1].isRed()){
					motTriple = true;
					total = total + matrice[i][j1].getContenu().getPoints();
				}
				else if(matrice[i][j1].isBlue())
					total = total + matrice[i][j1].getContenu().getPoints() * 3;
				else if(matrice[i][j1].isCyan())
					total = total + matrice[i][j1].getContenu().getPoints() * 2;
				else
					total = total + matrice[i][j1].getContenu().getPoints();
			}
		}
		System.out.println("Mot double : " + motDouble);
		if(motDouble){
			total = total * 2;
			System.out.println("Mot compte double !");
		}
		if(motTriple){
			total = total * 3;
			System.out.println("Mot compte triple !");
		}
		return total;
	}
	
	//Lorsqu'on ne pose qu'une seule lettre
	public int score(int i, int j){
		System.out.println("Première methode");
		int total = 0;
		boolean motDouble = false;
		boolean motTriple = false;
		getCase(i,j).whichColor();
		if(getCase(i,j).isPink()){
			motDouble = true;
			total =  getCase(i,j).getContenu().getPoints() ;
		}
		else if(getCase(i,j).isRed()){
			motTriple = true;
			total = getCase(i,j).getContenu().getPoints();
		}
		else if(getCase(i,j).isBlue())
			total = getCase(i,j).getContenu().getPoints() * 3;
		else if(getCase(i,j).isCyan())
			total = getCase(i,j).getContenu().getPoints() * 2;
		else
			total = getCase(i,j).getContenu().getPoints();
		System.out.println("Score : " + total);
		System.out.println("Mot double : " + motDouble);
		if(motDouble){
			total = total * 2;
			System.out.println("Mot compte double !");
		}
		if(motTriple){
			total = total * 3;
			System.out.println("Mot compte triple !");
		}
		return total;
	}
	
	/*public void addMot(String mot, int i, int j, String d) { //i et j sont les coordonnées de la premiere lettre de mot, d est la direction du mot(gauche à droite / haut en bas)
		int temp,g;	
		char[] charArray = mot.toCharArray();
		if(d.equals("droite"))
		{
			g = i;
			temp = i + charArray.length - 1;
			while(g<temp)
			{
				for(String c: charArray)
				{
					matrice[g][j].getContenu().setLettre(c);
					g++;
				}
			}
		}
		else if(d.equals("bas"))
		{
			g = j;
			temp = j + charArray.length -1;
			while(g<temp)
			{
				for(char c: charArray)
				{
					matrice[i][g].getContenu().setLettre(c);
					g++;
				}
			}
		}
	}*/
	
	public Case getCase(int i , int j ){
		return this.matrice[i][j];
	}
	public Case[][] getMatrice() {
		return matrice;
	}

	public void setMatrice(Case[][] matrice) {
		this.matrice = matrice;
	}

	public int getTaille() {
		return taille;
	}

	

/*	public void plateauRemp(char[][] tableau){
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				Case C1 = new Case();
				Piece P1 = new Piece(tableau[i][j]);
				C1.setContenu(P1);
				this.matrice[i][j] = C1;
			}
		}
	}*/

	public void setCase(Case C , int i , int j){
		this.matrice[i][j] = C;
	}
	
	public boolean isCaseGauche(int i ,int j) {
		if(j-1 >= 0)
			if(this.matrice[i][j-1].isPleine())
				return true;
		
		return false;
			
	}

	/**
	 * @return the caseHaut
	 */
	public boolean isCaseHaut(int i ,int j) {
	if(i-1 >= 0)
		if(this.matrice[i-1][j].isPleine())
			return true;
	
		return false;
	}
	
	public boolean isCaseDroite(int i ,int j) {
	if(j+1 < this.taille)
		if(this.matrice[i][j+1].isPleine())
			return true;
	
		return false;
	}

	/**
	 * @return the caseDessus
	 */
	public boolean isCaseBas(int i ,int j) {
	if(i+1 < this.taille)
		if(this.matrice[i+1][j].isPleine())
			return true;
	
		return false;
	}

	@Override
	public void addMot(String mot, int i, int j, String d) {
		// TODO Auto-generated method stub
		
	}



}