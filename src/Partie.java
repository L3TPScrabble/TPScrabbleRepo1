import java.util.List;

import interfaces.PartieInterface;

public class Partie implements PartieInterface{
	
	private List<Joueur> joueurs;
	private Sac sac;
	private Plateau plateau;
	
	

	public Partie() {
		super();
		this.joueurs = null;
		this.sac = new Sac();
		this.plateau = new Plateau();
	}



	public static void main(String[] args) {
		
	
	}

}
