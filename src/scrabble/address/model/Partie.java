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

	public String coupJoue(int x,int y,int compteur){
        Case c1 = new Case();
        String autorise = "";
        c1.setJouable(true);
        for(int i = -1;i<=1;i++){
	            if(i != 0 && !this.plateau.getCase(x+i,y).isPleine()){
	                this.plateau.setCase(c1,x+i,y);
	            }
	            if(i != 0 && !this.plateau.getCase(x,y+i).isPleine()){
	                this.plateau.setCase(c1,x,y+i);
	            }
        
        }
     
    	if(compteur>1){
    		System.out.println("ENTREE");
    		if(this.plateau.getCase(x+1, y).HasChanged() || this.plateau.getCase(x-2, y).HasChanged() || this.plateau.getCase(x+2, y).HasChanged()  || this.plateau.getCase(x-1, y).HasChanged()){	
    			System.out.println("Jeu autorisé sur colonne :"+y);
    			autorise = "c"+y;
    		}
    		if(this.plateau.getCase(x,y+1).HasChanged() || this.plateau.getCase(x,y+2).HasChanged() || this.plateau.getCase(x,y-2).HasChanged() || this.plateau.getCase(x, y-1).HasChanged()){
    			System.out.println("Jeu autorisé sur ligne :"+x);
    			autorise = "l"+x;

    		}
    	}
    	return autorise;
        
    }
	
	
	public void actualiseCaseJouable(){
		Case c1 = new Case();
		c1.setJouable(false);
		for(int x = 1;x<getPlateau().getTaille()-1;x++){
			for(int y = 1;y<getPlateau().getTaille()-1;y++){
						  if( !this.plateau.getCase(x,y).isPleine() && this.plateau.getCase(x,y).isJouable() && !this.plateau.isCaseHaut(x,y) && !this.plateau.isCaseBas(x,y) && !this.plateau.isCaseGauche(x,y) && !this.plateau.isCaseDroite(x, y)){
				               this.plateau.setCase(c1,x,y);}
					 /*
					  else  if(x == 0 ){
						  if(i != 0 && !this.plateau.getCase(x+i,y).isPleine() && this.plateau.getCase(x,y).isJouable() && !this.plateau.getCase(x+i,y).isCaseHaut(x,y) && !this.plateau.getCase(x+i,y).isCaseBas(x+i,y)  && !this.plateau.getCase(x,y).isCaseDroite(x,y) ){
			                this.plateau.setCase(c1,x+i,y);
						  }
			            }
					  else{
						  if(i != 0 && !this.plateau.getCase(x,y).isPleine() && this.plateau.getCase(x+i,y).isJouable() && !this.plateau.getCase(x+i,y).isCaseHaut(x,y) && !this.plateau.getCase(x,y).isCaseBas(x,y) && !this.plateau.getCase(x,y).isCaseGauche(x,y) && !this.plateau.getCase(x+i,y).isCaseDroite(x+i,y) )
				                this.plateau.setCase(c1,x,y);
					  }
					  if(y+i <= 0){
			            if(i != 0 && !this.plateau.getCase(x,y).isPleine() && this.plateau.getCase(x,y+i).isJouable() && !this.plateau.getCase(x,y).isCaseBas(x,y) && !this.plateau.getCase(x,y+i).isCaseGauche(x,y+i) && !this.plateau.getCase(x,y+i).isCaseDroite(x,y+i)){
			                this.plateau.setCase(c1,x,y);
			            }
					  }
			            else if(y+i == 14){
			            	if(i != 0 && !this.plateau.getCase(x,y).isPleine() && this.plateau.getCase(x,y).isJouable() && !this.plateau.getCase(x,y).isCaseHaut(x,y+i)  && !this.plateau.getCase(x,y).isCaseGauche(x,y) && !this.plateau.getCase(x,y).isCaseDroite(x,y))
				                this.plateau.setCase(c1,x,y);
			            }
			            else{
			            	if(i != 0 && !this.plateau.getCase(x,y).isPleine() && this.plateau.getCase(x,y).isJouable() && !this.plateau.getCase(x,y).isCaseHaut(x,y)  && !this.plateau.getCase(x,y).isCaseGauche(x,y) && !this.plateau.getCase(x,y).isCaseDroite(x,y) && !this.plateau.getCase(x,y).isCaseHaut(x, y)){
				                this.plateau.setCase(c1,x,y);
			            	}
			            }
				  }*/
		}
	}
}
	

	public void motFaux(){
		int iPremiereCase = 0;
		int jPremiereCase = 0;
		Case C1 = new Case();
		 C1.setPleine(false);
         C1.setHasChanged(false);
         C1.setJouable(true);
		Piece P1 = new Piece();
		C1.setContenu(P1);
		Case C2 = new Case();
		 C2.setPleine(false);
        C2.setHasChanged(false);
		Piece P2 = new Piece();
		C2.setContenu(P2);
		for(int i=0;i<getPlateau().getTaille();i++){		
			for(int j=0;j<getPlateau().getTaille();j++){
				if(getPlateau().getCase(i,j).HasChanged()){
					if(i == 7 && j == 7){
						C2.setJouable(true);
						getPlateau().setCase(C2,i,j);
					}
					else{
					getPlateau().setCase(C1,i,j);
					}
					System.out.println("MOT FAUX");
				}
					
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
				 System.out.println("Premiere case trouvé"+iPremiereCase+jPremiereCase);
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


	public Plateau getPlateau() {
		return plateau;
	}



	/**
	 * @param plateau the plateau to set
	 */
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}



	@Override
	public void newMot() {
		// TODO Auto-generated method stub
		
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

	

}
