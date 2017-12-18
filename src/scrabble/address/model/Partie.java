package scrabble.address.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import scrabble.address.model.Case;
import interfaces.JoueurInterface;
import interfaces.PartieInterface;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Partie implements PartieInterface{
	
	static Scanner sc = new Scanner(System.in);
	private static List<Joueur>participants;
	private static Sac sac;
	private Plateau plateau;
	
	

	public Partie() {
		
		Case c1 = new Case();
		Case c2 = new Case();
		c1.setJouable(true);
		this.participants = new ArrayList<Joueur>();
		this.sac = new Sac();
		this.plateau = new Plateau();
		for(int x=0;x<this.plateau.getTaille();x++){
			for(int y=0;y<this.plateau.getTaille();y++){
				this.plateau.setCase(c2, x, y);
				if((x == 0 && ( (y == 0) || (y == 7) || (y == 14) ) )
						   || (x == 7 && ( (y == 0) || (y == 14) ) )
						   || (x == 14 && ( (y == 0) || (y == 7) || (y == 14) ) )
						   )
							this.plateau.getCase(x, y).setIsRed(true);
						//Case rose
						else if((x == 1 && (y == 1 || y == 13)) || (x == 2 && (y == 2 || y == 12)) 
				        		|| (x == 3 && (y == 3 || y == 11)) || (x == 4 && (y == 4 || y == 10))
				        		|| (x == 10 && (y == 4 || y == 10)) || (y == 11 && (y == 3 || y == 11))
				        		|| (x == 12 && (y == 2 || y == 12)) || (x == 13 && (y == 1 || y == 13)))
							this.plateau.getCase(x, y).setIsPink(true);
						//Case Blue
						 else if((x == 1 && (y == 5 || y == 9)) 
				         		|| (x == 5 && (y == 1 || y == 5 || y == 9 || y == 13))
				         		|| (x == 9 && (y == 1 || y == 5 || y == 9 || y == 13))
				         		|| (x == 13 && (y == 5 || y == 9)))
							 this.plateau.getCase(x, y).setIsBlue(true);
						 else if(((x == 0 || x == 14) && (y == 3 || y == 11)) 
				         		|| ((x == 2 || x == 12) && (y == 6 || y == 8))
				         		|| ((x == 3 || x == 11) && (y == 0 || y == 7 || y == 14))
				         		|| ((x == 6 || x == 8) && (y == 2 || y == 6 || y == 8 || y == 12))
				         		|| (x == 7 && (y == 3 || y == 11)))
							 this.plateau.getCase(x, y).setIsCyan(true);
			}
		}
		this.plateau.setCase(c1,7,7);
		
	}
	
	
	public void newMot() {
		
	}
	
	public void Distribution(){
		for(Joueur j : participants)
			j.newMain(sac);
	}

	
	
	public static void afficherMain(int id) {
		for(Joueur j : participants) {
			if(j.getId() == id)
			for(Piece p : j.getMain())
				System.out.print(p.getLettre() + " ");
		}
		System.out.println();
	}
	
	public Sac getSac(){
		return sac;
	}
	
	public void setSac(Sac s){
		sac = s;
	}
	
	public List<Joueur> getParticipants (){
		return participants;
	}

	public void coupJoue(int x,int y){
        Case c1 = new Case();
        c1.setJouable(true);
        for(int i = -1;i<=1;i++){
            if(i != 0 && !this.plateau.getCase(x+i,y).isPleine()){
                this.plateau.setCase(c1,x+i,y);
            }
            if(i != 0 && !this.plateau.getCase(x,y+i).isPleine()){
                this.plateau.setCase(c1,x, y+i);
            }
        }
        
    }
	
	
	
	

	public String rechercheMot(){
		String mot = "";
		int compteur =0;
		int iPremiereCase = 0;
		int jPremiereCase = 0;
		boolean verif = false;
	for(int i=0;i<getPlateau().getTaille();i++){		
		for(int j=0;j<getPlateau().getTaille();j++){
			
			if(getPlateau().getCase(i,j).HasChanged() && compteur == 0){
				
				iPremiereCase = i;
				 jPremiereCase = j;
				 verif = true;
				 compteur++;
				 System.out.println("Premiere case trouv�"+iPremiereCase+jPremiereCase);
			}
				
		}
	}
	if(verif == true){
		if(getPlateau().isCaseDroite(iPremiereCase, jPremiereCase) || getPlateau().isCaseGauche(iPremiereCase, jPremiereCase)){
			if(getPlateau().isCaseGauche(iPremiereCase, jPremiereCase)){
				while(getPlateau().isCaseGauche(iPremiereCase, jPremiereCase)){
					jPremiereCase= jPremiereCase -1;

				}
			}
			while(getPlateau().getCase(iPremiereCase, jPremiereCase).isPleine()){
				mot = mot + getPlateau().getCase(iPremiereCase, jPremiereCase).getContenu().getLettre();
				jPremiereCase = jPremiereCase + 1;

			}
		
		}
		
		if(getPlateau().isCaseBas(iPremiereCase, jPremiereCase) || getPlateau().isCaseHaut(iPremiereCase, jPremiereCase)){
			if(getPlateau().isCaseHaut(iPremiereCase, jPremiereCase)){
				while(getPlateau().isCaseHaut(iPremiereCase, jPremiereCase)){
					iPremiereCase= iPremiereCase -1;

				}
			}
			while(getPlateau().getCase(iPremiereCase, jPremiereCase).isPleine()){
				mot = mot + getPlateau().getCase(iPremiereCase, jPremiereCase).getContenu().getLettre();
				iPremiereCase = iPremiereCase + 1;

			}
		}
	}
	
	return mot;
}

	public boolean verifMot(String mot) {
		File file = new File("dico.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		try {
			while ((line = br.readLine()) != null) {
			if(mot.equals(line))
				return true;
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public void newJoueur() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void newPartie() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void jouerMot() {
		// TODO Auto-generated method stub
		
	}
	public Plateau getPlateau() {
		return plateau;
	}

	

}
