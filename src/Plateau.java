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
	
	public int ScoreMot(String mot, int i, int j, String d) { //i et j sont les coordonnées de la premiere lettre de mot, d est la direction du mot(gauche à droite / haut en bas) 
		int temp,g;
		boolean motDouble = false, motTriple = false;
		char[] charArray = mot.toCharArray();
		int compteurPoints = 0;
		if(d.equals("droite"))
		{
			g = i;
			temp = i + charArray.length -1;
			while(g<temp)
			{
				for(char c : charArray)
				{
					if(matrice[g][j].getId() == 1) //case de couleur verte
						compteurPoints = compteurPoints + matrice[g][j].getContenu().getPoints();
					else if(matrice[g][j].getId() == 2) //case de couleur bleu clair
						compteurPoints = compteurPoints + matrice[g][j].getContenu().getPoints() * 2 ;
					else if(matrice[g][j].getId() == 3) //case de couleur bleu foncé
						compteurPoints = compteurPoints + matrice[g][j].getContenu().getPoints() * 3 ;
					else if(matrice[g][j].getId() == 4) //case de couleur rose
						motDouble = true;
					else if(matrice[g][j].getId() == 5) //case de couleur rouge
						motTriple = true;
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
				for(char c : charArray)
				{
					if(matrice[i][g].getId() == 1) //case de couleur verte
						compteurPoints = compteurPoints + matrice[i][g].getContenu().getPoints();
					else if(matrice[i][g].getId() == 2) //case de couleur bleu clair
						compteurPoints = compteurPoints + matrice[i][g].getContenu().getPoints() * 2 ;
					else if(matrice[i][g].getId() == 3) //case de couleur bleu foncé
						compteurPoints = compteurPoints + matrice[i][g].getContenu().getPoints() * 3 ;
					else if(matrice[i][g].getId() == 4) //case de couleur rose
						motDouble = true;
					else if(matrice[i][g].getId() == 5) //case de couleur rouge
						motTriple = true;
					g++;
				}
			}
		}
		if(motDouble == true)
			compteurPoints = compteurPoints * 2 ;
		if(motTriple == true)
			compteurPoints = compteurPoints * 3 ;
		return compteurPoints;
	}
	
	public void addMot(String mot, int i, int j, String d) { //i et j sont les coordonnées de la premiere lettre de mot, d est la direction du mot(gauche à droite / haut en bas)
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
	}
	
}
	
	

