import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import interfaces.CaseInterface;
import interfaces.PlateauInterface;

public class Plateau implements PlateauInterface{
	private Case[][] matrice;
	private int taille;
//    private JPanel total;

	

	public Plateau() {
		this.taille = 15;
		this.matrice = new Case[taille][taille];
	
	}
	
/*	public Plateau() {
		this.taille = 15;
		int i , j = 0;
        JPanel fenetre = new JPanel();
		total = new JPanel();
        fenetre.setLayout(new GridLayout(15,15));
		JButton[][] matrice = new JButton[taille][taille];
		
		for(i=0;i<15;i++){
			for(j=0;j<15;j++){
				JButton a = new JButton();
				matrice[i][j] = a;
				matrice[i][j].setText(".");
	    		fenetre.add(matrice[i][j]);
	    	
			}
	
	    	
	    
        total.add(fenetre);

	} 
} */
	
	
	public Boolean estPlein() {
		for(int i=0; i<15 ; i++)
			for(int j=0; j<15; j++)
				if(matrice[i][j].estVide())
					return false;			
		return true;
	}
	
	
	public int ScoreMot(String mot) {
		char[] charArray = mot.toCharArray();
		//???
		return 0;
	}
	
	public void addMot(String mot, int i, int j, String d) {
		int temp,g;	
		char[] charArray = mot.toCharArray();
		if(d.equals("droite"))
		{
			g = i;
			temp = i + charArray.length - 1;
			while(g<temp)
			{
				for(char c: charArray)
				{
					matrice[g][j].contenu.lettre = c;
					g++;
				}
			}
		}		
}
	
}
