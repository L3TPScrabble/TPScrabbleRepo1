import interfaces.CaseInterface;
import interfaces.PlateauInterface;

public class Plateau implements PlateauInterface{
	private Case[][] matrice;
	private int taille;
	
	
	public Plateau() {
		this.taille = 15;
		this.matrice = new Case[taille][taille];
	
	}
	
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
